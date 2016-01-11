package org.sanelib.eboss.api.converters.client;


import org.junit.Test;
import org.sanelib.eboss.api.dto.client.ClientDTO;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.client.UpdateClient;
import org.sanelib.eboss.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateClientConverterTest {

    @Test
    public void testUpdateClientSuccessExecute() throws Exception{
        ClientDTO dto = new ClientDTO();
        dto.setId("12");
        dto.setClientId("123");
        dto.setClientSecret("secret");
        dto.setClientName("WEB");
        dto.setDescription("Description");
        dto.setClientUrl("url");
        dto.setClientType("type");
        dto.setScope("Scope");
        dto.setRedirectUri("redirect");
        dto.setRegdate("2005/04/01");

        ProcessError processError = new ProcessError();

        UpdateClientConverter updateClientConverter = new UpdateClientConverter();
        ProcessCommand command = updateClientConverter.convert(dto, processError);


        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateClient);
        UpdateClient updateClient = (UpdateClient) command;
        assertEquals(dto.getClientId(),updateClient.getClientId());
        assertEquals(dto.getClientSecret(), updateClient.getClientSecret());
        assertEquals(dto.getClientName(),updateClient.getClientName());
        assertEquals(dto.getDescription(),updateClient.getDescription());
        assertEquals(dto.getClientUrl(),updateClient.getClientUrl());
        assertEquals(dto.getClientType(),updateClient.getClientType());
        assertEquals(dto.getScope(),updateClient.getScope());
        assertEquals(dto.getRedirectUri(),updateClient.getRedirectUri());
        assertEquals(dto.getRegdate(), DateHelper.toDateString((updateClient.getRegdate())));

    }

}
