package org.sanelib.eboss.core.activities.customer;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.customer.AddCustomer;
import org.sanelib.eboss.core.commands.customer.UpdateCustomer;
import org.sanelib.eboss.core.dao.CustomerRepository;
import org.sanelib.eboss.core.domain.entity.Customer;
import org.sanelib.eboss.core.exceptions.AppException;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CheckCustomerDuplicationDelegate implements JavaDelegate {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Checking customer for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        Long existingCustomerId = (command instanceof UpdateCustomer) ? ((UpdateCustomer) command).getId() : null;

        //Name duplication check
        String customerName = ((AddCustomer) command).getName();

        List<Customer> customers = customerRepository.findByColumnAndValue("name", customerName);

        if(!customers.isEmpty() && !Objects.equals(existingCustomerId, customers.get(0).getId())){
            processError.addError("common.field.duplicate", "name", Arrays.asList("domain.customer.name", "domain.customer.name"), customerName);
        }

        //Email duplication check
        String emailAddress = ((AddCustomer) command).getEmail();

        customers = customerRepository.findByColumnAndValue("email", emailAddress);

        if(!customers.isEmpty() && !Objects.equals(existingCustomerId, customers.get(0).getId())){
            processError.addError("common.field.duplicate", "email", Arrays.asList("domain.customer.name", "domain.customer.email"), emailAddress);
        }



        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
