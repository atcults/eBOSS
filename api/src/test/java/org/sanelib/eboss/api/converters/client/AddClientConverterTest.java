package org.sanelib.eboss.api.converters.client;


import org.junit.Test;
import org.sanelib.eboss.api.dto.client.ClientDTO;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.client.AddClient;
import org.sanelib.eboss.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddClientConverterTest {

    @Test
    public void testAddClientSuccessExecute() throws Exception {

        ClientDTO dto=new ClientDTO();
        dto.setClient_secret("secret");
        dto.setClient_name("WEB");
        dto.setDescription("Description");
        dto.setClient_url("url");
        dto.setClient_type("type");
        dto.setScope("Scope");
        dto.setRedirect_uri("redirect");
        dto.setRegdate("2005/04/01");

        ProcessError processError = new ProcessError();

        AddClientConverter addClientConverter = new AddClientConverter();
        ProcessCommand command = addClientConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());

        assertTrue("Wrong output " + command, command instanceof AddClient);
        AddClient addClient = (AddClient) command;

        assertEquals(dto.getClient_secret(), addClient.getClient_secret());
        assertEquals(dto.getClient_name(),addClient.getClient_name());
        assertEquals(dto.getDescription(),addClient.getDescription());
        assertEquals(dto.getClient_url(),addClient.getClient_url());
        assertEquals(dto.getClient_type(),addClient.getClient_type());
        assertEquals(dto.getScope(),addClient.getScope());
        assertEquals(dto.getRedirect_uri(),addClient.getRedirect_uri());
        assertEquals(dto.getRegdate(), DateHelper.toDateString((addClient.getRegdate())));

    }

    }
