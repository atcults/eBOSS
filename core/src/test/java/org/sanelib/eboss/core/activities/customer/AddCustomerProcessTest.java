package org.sanelib.eboss.core.activities.customer;

import org.junit.Test;
import org.sanelib.eboss.common.utils.RegularExpressionHelper;
import org.sanelib.eboss.BaseSpringJUnitTest;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.customer.AddCustomer;
import org.sanelib.eboss.core.domain.entity.Customer;

import static org.junit.Assert.*;

public class AddCustomerProcessTest extends BaseSpringJUnitTest {

    @Test
    public void testAddCustomerProcessTest() throws Throwable {

        AddCustomer addCustomer = new AddCustomer();
        addCustomer.setName("Customer name");
        addCustomer.setContactPersonName("Contact person name");
        addCustomer.setAddress("Amedabad");
        addCustomer.setCountry("India");
        addCustomer.setPhone("+91-9876543210");
        addCustomer.setEmail("name@yahoo.com");
        addCustomer.setFax("+91-9876543210");
        addCustomer.setWebsite("www.google.com");
        addCustomer.setNotes("New Customer");

        String result = execute(addCustomer, ActivitiProcessConstants.Admin.ADD_CUSTOMER);

        assertNotNull(result);
        assertTrue(RegularExpressionHelper.checkIdFormat(result));

        Long id = Long.parseLong(result);

        Customer customer = load(Customer.class, id);

        assertNotNull(customer);

        assertEquals(addCustomer.getName(), customer.getName());
        assertEquals(addCustomer.getContactPersonName(), customer.getContactPersonName());
        assertEquals(addCustomer.getAddress(),customer.getAddress());
        assertEquals(addCustomer.getCountry(),customer.getCountry());
        assertEquals(addCustomer.getPhone(),customer.getPhone());
        assertEquals(addCustomer.getEmail(),customer.getEmail());
        assertEquals(addCustomer.getFax(),customer.getFax());
        assertEquals(addCustomer.getWebsite(),customer.getWebsite());
        assertEquals(addCustomer.getNotes(),customer.getNotes());
    }
}
