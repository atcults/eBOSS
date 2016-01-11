package org.sanelib.eboss.core.activities.customer;

import org.junit.Test;
import org.sanelib.eboss.EntityIntegrationTestBase;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.customer.DeleteCustomer;
import org.sanelib.eboss.core.domain.entity.Customer;

import static org.junit.Assert.assertNull;

public class DeleteCustomerProcessTest extends EntityIntegrationTestBase {

    @Test
    public void testDeleteCustomerSuccess() throws Throwable {

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

        DeleteCustomer deleteCustomer = new DeleteCustomer();
        deleteCustomer.setId(customer.getId());

        String result = execute(deleteCustomer, ActivitiProcessConstants.Admin.DELETE_CUSTOMER);
        assertNull(result);

        Customer deletedCustomer = fetch(Customer.class,customer.getId());
        assertNull(deletedCustomer);
    }
}
