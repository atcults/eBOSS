package org.sanelib.eboss.core.activities.customer;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.customer.UpdateCustomer;
import org.sanelib.eboss.core.dao.CustomerRepository;
import org.sanelib.eboss.core.domain.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateCustomerDelegate implements JavaDelegate {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Update Customer called");

        UpdateCustomer updateCustomer = (UpdateCustomer) execution.getVariable("command");

        Customer customer = customerRepository.get(updateCustomer.getId());

        customer.setId(updateCustomer.getId());
        customer.setName(updateCustomer.getName());
        customer.setContactPersonName(updateCustomer.getContactPersonName());
        customer.setAddress(updateCustomer.getAddress());
        customer.setCountry(updateCustomer.getCountry());
        customer.setPhone(updateCustomer.getPhone());
        customer.setEmail(updateCustomer.getEmail());
        customer.setFax(updateCustomer.getFax());
        customer.setWebsite(updateCustomer.getWebsite());
        customer.setNotes(updateCustomer.getNotes());
        customerRepository.update(customer);
    }
}
