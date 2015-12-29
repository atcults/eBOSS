package org.sanelib.eboss.core.activities.customer;


import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.junit.Test;
import org.sanelib.eboss.core.IntegrationTestBase;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.customer.AddCustomer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class AddCustomerProcessTest extends IntegrationTestBase {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Test
    public void testAddCustomerProcessTest() throws Exception {

        AddCustomer customer = new AddCustomer();
        customer.setName("Customer name");
        customer.setContactPersonName("Contact person name");
        customer.setAddress("Amedabad");
        customer.setCountry("India");
        customer.setPhone("+91-9876543210");
        customer.setEmail("name@yahoo.com");
        customer.setFax("+91-9876543210");
        customer.setWebsite("www.google.com");
        customer.setNotes("New Customer");

        Map<String, Object> variables = new HashMap<>();
        variables.put("command", customer);
        runtimeService.startProcessInstanceByKey(ActivitiProcessConstants.Admin.ADD_CUSTOMER, variables);
    }

}
