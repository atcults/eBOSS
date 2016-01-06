package org.sanelib.eboss.core.activities.employee;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.employee.UpdateEmployee;
import org.sanelib.eboss.core.dao.EmployeeRepository;
import org.sanelib.eboss.core.domain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateEmployeeDelegate implements JavaDelegate {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Update Employee called");

        UpdateEmployee updateEmployee = (UpdateEmployee) execution.getVariable("command");

        Employee employee = employeeRepository.get(updateEmployee.getId());

        employee.setId(updateEmployee.getId());
        employee.setCode(updateEmployee.getCode());
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setMiddleName(updateEmployee.getMiddleName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setDateOfBirth(updateEmployee.getDateOfBirth());
        employee.setAddressLine1(updateEmployee.getAddressLine1());
        employee.setAddressLine2(updateEmployee.getAddressLine2());
        employee.setCity(updateEmployee.getCity());
        employee.setState(updateEmployee.getState());
        employee.setCountry(updateEmployee.getCountry());
        employee.setZipCode(updateEmployee.getZipCode());
        employee.setPhone(updateEmployee.getPhone());
        employee.setEmail(updateEmployee.getEmail());
        employee.setGender(updateEmployee.getGender());
        employee.setDateOfJoining(updateEmployee.getDateOfJoining());
        employee.setIsActive(updateEmployee.getIsActive());
        employeeRepository.update(employee);

    }
}
