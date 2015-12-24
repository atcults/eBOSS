package org.sanelib.eboss.core.activities.employee;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.employee.AddEmployee;
import org.sanelib.eboss.core.dao.EmployeeRepository;
import org.sanelib.eboss.core.domain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddEmployeeDelegate implements JavaDelegate {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Add Employee called");

        AddEmployee command = (AddEmployee) execution.getVariable("command");

        Employee entity = new Employee();
        entity.setCode(command.getCode());
        entity.setFirstName(command.getFirstName());
        entity.setMiddleName(command.getMiddleName());
        entity.setLastName(command.getLastName());
        entity.setDateOfBirth(command.getDateOfBirth());
        entity.setAddressLine1(command.getAddressLine1());
        entity.setAddressLine2(command.getAddressLine2());
        entity.setCity(command.getCity());
        entity.setState(command.getState());
        entity.setCountry(command.getCountry());
        entity.setZipCode(command.getZipCode());
        entity.setPhone(command.getPhone());
        entity.setEmail(command.getEmail());
        entity.setGender(command.getGender());
        entity.setDateOfJoining(command.getDateOfJoining());
        entity.setIsActive(command.getIsActive());
        employeeRepository.save(entity);
        execution.setVariable("result", entity.getId());
	}
}
