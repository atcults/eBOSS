package org.sanelib.eboss.core.activities.customer;


import org.junit.Test;
import org.sanelib.eboss.common.utils.RegularExpressionHelper;
import org.sanelib.eboss.EntityIntegrationTestBase;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.customer.UpdateCustomer;
import org.sanelib.eboss.core.domain.entity.Customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UpdateCustomerProcessTest extends EntityIntegrationTestBase {
    @Test
    public void testUpdateCustomerProcessTest() throws Throwable {
        UpdateCustomer update = new UpdateCustomer();

        update.setName("Customer name");
        update.setContactPersonName("Contact person name");
        update.setAddress("Amedabad");
        update.setCountry("India");
        update.setPhone("+91-9876543210");
        update.setEmail("name@yahoo.com");
        update.setFax("+91-9876543210");
        update.setWebsite("www.google.com");
        update.setNotes("New Customer");

        String result = execute(update, ActivitiProcessConstants.Admin.ADD_CUSTOMER);

        assertNotNull(result);
        assertTrue(RegularExpressionHelper.checkIdFormat(result));

        Long id = Long.parseLong(result);

        Customer customer = fetch(Customer.class, id);

        assertNotNull(customer);

        assertEquals(update.getName(), customer.getName());
        assertEquals(update.getContactPersonName(), customer.getContactPersonName());
        assertEquals(update.getAddress(),customer.getAddress());
        assertEquals(update.getCountry(),customer.getCountry());
        assertEquals(update.getPhone(),customer.getPhone());
        assertEquals(update.getEmail(),customer.getEmail());
        assertEquals(update.getFax(),customer.getFax());
        assertEquals(update.getWebsite(),customer.getWebsite());
        assertEquals(update.getNotes(),customer.getNotes());

    }

}
