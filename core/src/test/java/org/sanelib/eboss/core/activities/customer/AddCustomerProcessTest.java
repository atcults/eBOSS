package org.sanelib.eboss.core.activities.customer;

import org.junit.Test;
import org.sanelib.eboss.common.utils.RegularExpressionHelper;
import org.sanelib.eboss.core.BaseSpringJUnitTest;
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
    }
}
