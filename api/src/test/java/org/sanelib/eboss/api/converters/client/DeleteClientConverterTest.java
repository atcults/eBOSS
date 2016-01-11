package org.sanelib.eboss.api.converters.client;


import org.junit.Test;
import org.sanelib.eboss.api.dto.client.ClientDTO;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.client.AddClient;
import org.sanelib.eboss.core.commands.client.DeleteClient;
import org.sanelib.eboss.core.domain.entity.Client;
import org.sanelib.eboss.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteClientConverterTest {

    @Test
    public void testDeleteClientSuccessExecute() throws Exception {

        ClientDTO dto=new ClientDTO();
        dto.setId("1");

        ProcessError processError = new ProcessError();

        DeleteClientConverter deleteClientConverter = new DeleteClientConverter();
        ProcessCommand command = deleteClientConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteClient);
        DeleteClient deleteClient = (DeleteClient) command;

        assertEquals("Id is not mapped", dto.getId(), Long.toString(deleteClient.getId()));

    }
}
