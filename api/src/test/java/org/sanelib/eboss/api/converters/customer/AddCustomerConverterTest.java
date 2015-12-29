package org.sanelib.eboss.api.converters.customer;


import org.junit.Before;
import org.junit.Test;
import org.sanelib.eboss.api.dto.customer.CustomerDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.customer.AddCustomer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddCustomerConverterTest {

    AddCustomerConverter addCustomerConverter;

    @Before
    public void setUp(){ addCustomerConverter = new AddCustomerConverter(); }

    @Test
    public void testAddCustomerSuccessExecute() throws Exception{

        CustomerDTO dto = new CustomerDTO();
        dto.setName("Megha");
        dto.setContactPersonName("Priya Mehta");
        dto.setAddress("2, Soft Colony, Mangrol, Gujarat");
        dto.setCountry("India");
        dto.setPhone("+91-9876543210");
        dto.setEmail("megh@yahoo.com");
        dto.setFax("+91-9876543210");
        dto.setWebsite("www.google.com");
        dto.setNotes("New Customer");
        ProcessCommand command = addCustomerConverter.convert(dto);
        assertTrue("Wrong output " + command, command instanceof AddCustomer);
        AddCustomer addCustomer = (AddCustomer) command;
        assertEquals("Id is not mapped", dto.getId(), addCustomer.getId());
        assertEquals("Name is not mapped", dto.getName(),addCustomer.getName());
        assertEquals("Contact Person Name is not mapped", dto.getContactPersonName(),addCustomer.getContactPersonName());
        assertEquals("Address is not mapped", dto.getAddress(),addCustomer.getAddress());
        assertEquals("Country is not mapped", dto.getCountry(),addCustomer.getCountry());
        assertEquals("Phone is not mapped", dto.getPhone(),addCustomer.getPhone());
        assertEquals("Email is not mapped", dto.getEmail(),addCustomer.getEmail());
        assertEquals("Fax is not mapped", dto.getFax(),addCustomer.getFax());
        assertEquals("Website is not mapped", dto.getWebsite(),addCustomer.getWebsite());
        assertEquals("Notes is not mapped", dto.getNotes(),addCustomer.getNotes());
    }
}
