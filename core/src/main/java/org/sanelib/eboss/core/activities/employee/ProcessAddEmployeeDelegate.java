package org.sanelib.eboss.core.activities.employee;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.employee.AddEmployee;
import org.sanelib.eboss.core.dao.EmployeeRepository;
import org.sanelib.eboss.core.domain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Component
public class ProcessAddEmployeeDelegate implements JavaDelegate {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Add Employee called");

        AddEmployee command = (AddEmployee) execution.getVariable("command");

        Employee entity = new Employee();
        entity.setEmpId(Long.valueOf(command.getEmployeeId()));
        entity.setFirstName(command.getFirstName());
        entity.setLastName(command.getLastName());
        entity.setGender(command.getGender());

/*
        Timestamp joinDate = null, birthDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        try {
            Date birthDateParsed = dateFormat.parse(command.getDateOfBirth());
            Date joinDateParsed = dateFormat.parse(command.getDateOfJoining());

            birthDate = new Timestamp(birthDateParsed.getTime());
            joinDate = new Timestamp(joinDateParsed.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        entity.setDateOfBirth(birthDate);
        entity.setDateOfJoining(joinDate);
*/

        employeeRepository.save(entity);

        execution.setVariable("result", entity.getId());

	}
}
