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
        dto.setId("1");
        dto.setClientId("CL001");
        dto.setClientSecret("secret");
        dto.setClientName("WEB");
        dto.setDescription("Description");
        dto.setClientUrl("url");
        dto.setClientType("type");
        dto.setScope("Scope");
        dto.setRedirectUri("redirect");
        dto.setRegdate("2005/04/01");

        ProcessError processError = new ProcessError();

        AddClientConverter addClientConverter = new AddClientConverter();
        ProcessCommand command = addClientConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddClient);
        AddClient addClient = (AddClient) command;

        assertEquals(dto.getClientId(),addClient.getClientId());
        assertEquals(dto.getClientSecret(), addClient.getClientSecret());
        assertEquals(dto.getClientName(),addClient.getClientName());
        assertEquals(dto.getDescription(),addClient.getDescription());
        assertEquals(dto.getClientUrl(),addClient.getClientUrl());
        assertEquals(dto.getClientType(),addClient.getClientType());
        assertEquals(dto.getScope(),addClient.getScope());
        assertEquals(dto.getRedirectUri(),addClient.getRedirectUri());
        assertEquals(dto.getRegdate(), DateHelper.toDateString((addClient.getRegDate())));

    }

    }
