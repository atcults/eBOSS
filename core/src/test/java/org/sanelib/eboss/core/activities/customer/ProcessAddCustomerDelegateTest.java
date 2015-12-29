package org.sanelib.eboss.core.activities.customer;


import org.activiti.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sanelib.eboss.core.commands.customer.AddCustomer;
import org.sanelib.eboss.core.dao.CustomerRepository;
import org.sanelib.eboss.core.domain.entity.Customer;

public class ProcessAddCustomerDelegateTest {

    CustomerRepository customerRepositoryMock;

    ProcessAddCustomerDelegate processAddCustomerDelegate;

    @Before
    public void setUp(){
        customerRepositoryMock = Mockito.mock(CustomerRepository.class);
        processAddCustomerDelegate = new ProcessAddCustomerDelegate();
        processAddCustomerDelegate.customerRepository = customerRepositoryMock;
    }

    @Test
    public void testAddCustomerSuccessExecute() throws Exception{

        Mockito.doNothing().when(customerRepositoryMock).save(Mockito.isA(Customer.class));

        AddCustomer addCustomerCommand = new AddCustomer();
        addCustomerCommand.setName("Megha Patel");
        addCustomerCommand.setContactPersonName("Priya Mehta");
        addCustomerCommand.setAddress("2, Soft Colony, Mangrol,Gujarat");
        addCustomerCommand.setCountry("India");
        addCustomerCommand.setPhone("+91-9876543210");
        addCustomerCommand.setEmail("megh@yahoo.com");
        addCustomerCommand.setFax("76543211");
        addCustomerCommand.setWebsite("www.google.com");
        addCustomerCommand.setNotes("New Customer");

        DelegateExecution execution = Mockito.mock(DelegateExecution.class);
        Mockito.when(execution.getVariable("command")).thenReturn(addCustomerCommand);

        processAddCustomerDelegate.execute(execution);

        Mockito.verify(execution).setVariable("result", 0L);
    }

}
