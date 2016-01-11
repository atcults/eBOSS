package org.sanelib.eboss.core.activities.customer;


import org.apache.ibatis.annotations.Update;
import org.junit.Test;
import org.sanelib.eboss.common.utils.RegularExpressionHelper;
import org.sanelib.eboss.BaseSpringJUnitTest;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.customer.UpdateCustomer;
import org.sanelib.eboss.core.domain.entity.Customer;

import static org.junit.Assert.*;

public class UpdateCustomerProcessTest extends BaseSpringJUnitTest {
    @Test
    public void testUpdateCustomerProcessTest() throws Throwable {
        Customer customer = new Customer();
        customer.setName("Customer name");
        customer.setContactPersonName("Contact person name");
        customer.setAddress("Amedabad");
        customer.setCountry("India");
        customer.setPhone("+91-9876543210");
        customer.setEmail("name@yahoo.com");
        customer.setFax("+91-9876543210");
        customer.setWebsite("www.google.com");
        customer.setNotes("New Customer");

        persist(customer);

        UpdateCustomer update = new UpdateCustomer();
        update.setId(customer.getId());
        update.setName("NewCustomer name");
        update.setContactPersonName("NewContact person name");
        update.setAddress("NewAmedabad");
        update.setCountry("NewIndia");
        update.setPhone("+91-9876543210");
        update.setEmail("newname@yahoo.com");
        update.setFax("+91-9876543210");
        update.setWebsite("www.google.com");
        update.setNotes("New2 Customer");

        String result = execute(update, ActivitiProcessConstants.Admin.UPDATE_CUSTOMER);

        assertNull(result);
        assertNotNull(update);

        assertEquals("NewCustomer name", update.getName());
        assertEquals("NewContact person name", update.getContactPersonName());
        assertEquals("NewAmedabad",update.getAddress());
        assertEquals("NewIndia",update.getCountry());
        assertEquals("+91-9876543210",update.getPhone());
        assertEquals("newname@yahoo.com",update.getEmail());
        assertEquals("+91-9876543210",update.getFax());
        assertEquals("www.google.com",update.getWebsite());
        assertEquals("New2 Customer",update.getNotes());

    }

}
