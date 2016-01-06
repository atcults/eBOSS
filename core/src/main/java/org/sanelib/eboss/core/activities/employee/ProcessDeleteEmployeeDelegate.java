package org.sanelib.eboss.core.activities.employee;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.employee.DeleteEmployee;
import org.sanelib.eboss.core.dao.EmployeeRepository;
import org.sanelib.eboss.core.domain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteEmployeeDelegate implements JavaDelegate {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Employee Delete called");

        DeleteEmployee deleteEmployee = (DeleteEmployee) execution.getVariable("command");
        Employee employee = this.employeeRepository.load(deleteEmployee.getId());
        employeeRepository.remove(employee);
    }
}
