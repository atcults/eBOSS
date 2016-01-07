package org.sanelib.eboss.core.activities.customer;


import org.activiti.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sanelib.eboss.core.commands.customer.AddCustomer;
import org.sanelib.eboss.core.commands.customer.UpdateCustomer;
import org.sanelib.eboss.core.dao.CustomerRepository;
import org.sanelib.eboss.core.domain.entity.Customer;

public class ProcessUpdateCustomerDelegateTest {

    CustomerRepository customerRepositoryMock;

    ProcessAddCustomerDelegate processAddCustomerDelegate;

    @Before
    public void setUp(){
        customerRepositoryMock = Mockito.mock(CustomerRepository.class);
        processAddCustomerDelegate = new ProcessAddCustomerDelegate();
        processAddCustomerDelegate.customerRepository = customerRepositoryMock;
    }

    @Test
    public void testAddCustomerSuccessExecute() throws Exception {

        Mockito.doNothing().when(customerRepositoryMock).save(Mockito.isA(Customer.class));

        UpdateCustomer updateCustomer = new UpdateCustomer();
        updateCustomer.setName("Megha Patel");
        updateCustomer.setContactPersonName("Priya Mehta");
        updateCustomer.setAddress("2, Soft Colony, Mangrol,Gujarat");
        updateCustomer.setCountry("India");
        updateCustomer.setPhone("+91-9876543210");
        updateCustomer.setEmail("megh@yahoo.com");
        updateCustomer.setFax("76543211");
        updateCustomer.setWebsite("www.google.com");
        updateCustomer.setNotes("New Customer");

        DelegateExecution execution = Mockito.mock(DelegateExecution.class);
        Mockito.when(execution.getVariable("command")).thenReturn(updateCustomer);

    }

    }
