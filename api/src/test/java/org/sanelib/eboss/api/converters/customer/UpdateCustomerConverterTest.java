package org.sanelib.eboss.api.converters.customer;

import org.junit.Test;
import org.sanelib.eboss.api.dto.customer.CustomerDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.customer.AddCustomer;
import org.sanelib.eboss.core.commands.customer.UpdateCustomer;
import org.sanelib.eboss.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateCustomerConverterTest {

    @Test
    public void testUpdateCustomerSuccessExecute() throws Exception{

        CustomerDTO dto = new CustomerDTO();
        dto.setId("2");
        dto.setName("Megha");
        dto.setContactPersonName("Priya Mehta");
        dto.setAddress("2, Soft Colony, Mangrol, Gujarat");
        dto.setCountry("India");
        dto.setPhone("+91-9876543210");
        dto.setEmail("megh@yahoo.com");
        dto.setFax("+91-9876543210");
        dto.setWebsite("www.google.com");
        dto.setNotes("New Customer");

        ProcessError processError = new ProcessError();

        UpdateCustomerConverter updateCustomerConverter = new UpdateCustomerConverter();
        ProcessCommand command = updateCustomerConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddCustomer);
        UpdateCustomer updateCustomer = (UpdateCustomer) command;
        assertEquals("Id is not mapped", dto.getId(), Long.toString(updateCustomer.getId()));
        assertEquals("Name is not mapped", dto.getName(),updateCustomer.getName());
        assertEquals("Contact Person Name is not mapped", dto.getContactPersonName(),updateCustomer.getContactPersonName());
        assertEquals("Address is not mapped", dto.getAddress(),updateCustomer.getAddress());
        assertEquals("Country is not mapped", dto.getCountry(),updateCustomer.getCountry());
        assertEquals("Phone is not mapped", dto.getPhone(),updateCustomer.getPhone());
        assertEquals("Email is not mapped", dto.getEmail(),updateCustomer.getEmail());
        assertEquals("Fax is not mapped", dto.getFax(),updateCustomer.getFax());
        assertEquals("Website is not mapped", dto.getWebsite(),updateCustomer.getWebsite());
        assertEquals("Notes is not mapped", dto.getNotes(),updateCustomer.getNotes());

    }

}
