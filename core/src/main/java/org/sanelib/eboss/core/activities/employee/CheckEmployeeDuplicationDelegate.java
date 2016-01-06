package org.sanelib.eboss.core.activities.employee;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.employee.AddEmployee;
import org.sanelib.eboss.core.commands.employee.UpdateEmployee;
import org.sanelib.eboss.core.dao.EmployeeRepository;
import org.sanelib.eboss.core.domain.entity.Employee;
import org.sanelib.eboss.core.exceptions.AppException;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CheckEmployeeDuplicationDelegate implements JavaDelegate {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Checking employee for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        Long existingEmployeeId = (command instanceof UpdateEmployee) ? ((UpdateEmployee) command).getId() : null;

        //Code duplication check
        String employeeCode = ((AddEmployee) command).getCode();

        List<Employee> employees = employeeRepository.findByColumnAndValue("code", employeeCode);

        if(!employees.isEmpty() && !Objects.equals(existingEmployeeId, employees.get(0).getId())){
            processError.addError("common.field.duplicate", "code", Arrays.asList("domain.employee.name", "domain.employee.code"), employeeCode);
        }

        //Email duplication check
        String emailAddress = ((AddEmployee) command).getEmail();

        employees = employeeRepository.findByColumnAndValue("email", emailAddress);

        if(!employees.isEmpty() && !Objects.equals(existingEmployeeId, employees.get(0).getId())){
            processError.addError("common.field.duplicate", "email", Arrays.asList("domain.employee.name", "domain.employee.email"), emailAddress);
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
