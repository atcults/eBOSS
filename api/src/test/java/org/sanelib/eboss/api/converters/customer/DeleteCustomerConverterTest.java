package org.sanelib.eboss.api.converters.customer;


import org.junit.Test;
import org.sanelib.eboss.api.converters.client.DeleteClientConverter;
import org.sanelib.eboss.api.dto.client.ClientDTO;
import org.sanelib.eboss.api.dto.customer.CustomerDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.client.DeleteClient;
import org.sanelib.eboss.core.commands.customer.DeleteCustomer;
import org.sanelib.eboss.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteCustomerConverterTest {

    @Test
    public void testDeleteCustomerSuccessExecute() throws Exception {

        CustomerDTO dto=new CustomerDTO();
        dto.setId("1");

        ProcessError processError = new ProcessError();

        DeleteCustomerConverter deleteCustomerConverter = new DeleteCustomerConverter();
        ProcessCommand command = deleteCustomerConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteCustomer);
        DeleteCustomer deleteCustomer = (DeleteCustomer) command;

        assertEquals("Id is not mapped", dto.getId(), Long.toString(deleteCustomer.getId()));

    }
}
