package org.sanelib.eboss.core.activities.customer;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.customer.DeleteCustomer;
import org.sanelib.eboss.core.dao.CustomerRepository;
import org.sanelib.eboss.core.domain.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteCustomerDelegate implements JavaDelegate {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Customer Delete called");

        DeleteCustomer deleteCustomer = (DeleteCustomer) execution.getVariable("command");
        Customer customer = this.customerRepository.load(deleteCustomer.getId());
        customerRepository.remove(customer);
    }
}
