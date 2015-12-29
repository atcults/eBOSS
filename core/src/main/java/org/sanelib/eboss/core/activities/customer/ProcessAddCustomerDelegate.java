package org.sanelib.eboss.core.activities.customer;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import org.sanelib.eboss.core.commands.customer.AddCustomer;
import org.sanelib.eboss.core.dao.CustomerRepository;
import org.sanelib.eboss.core.domain.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddCustomerDelegate implements JavaDelegate {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Add Customer called");

        AddCustomer command = (AddCustomer) execution.getVariable("command");

        Customer entity = new Customer();
        entity.setName(command.getName());
        entity.setContactPersonName(command.getContactPersonName());
        entity.setAddress(command.getAddress());
        entity.setCountry(command.getCountry());
        entity.setPhone(command.getPhone());
        entity.setEmail(command.getEmail());
        entity.setFax(command.getFax());
        entity.setWebsite(command.getWebsite());
        entity.setNotes(command.getNotes());
        customerRepository.save(entity);
        execution.setVariable("result", entity.getId());
    }
}
