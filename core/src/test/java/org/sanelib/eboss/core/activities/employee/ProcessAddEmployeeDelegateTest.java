package org.sanelib.eboss.core.activities.employee;


import org.activiti.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sanelib.eboss.core.commands.employee.AddEmployee;
import org.sanelib.eboss.core.dao.EmployeeRepository;
import org.sanelib.eboss.core.domain.entity.Employee;

public class ProcessAddEmployeeDelegateTest {

    EmployeeRepository employeeRepositoryMock;

    ProcessAddEmployeeDelegate processAddEmployeeDelegate;

    @Before
    public void setUp(){
        employeeRepositoryMock = Mockito.mock(EmployeeRepository.class);
        processAddEmployeeDelegate = new ProcessAddEmployeeDelegate();
        processAddEmployeeDelegate.employeeRepository = employeeRepositoryMock;
    }

    @Test
    public void testAddEmployeeSuccessExecute() throws Exception{

        Mockito.doNothing().when(employeeRepositoryMock).save(Mockito.isA(Employee.class));

        AddEmployee addEmployeeCommand = new AddEmployee();
        addEmployeeCommand.setEmployeeId(101);
        addEmployeeCommand.setDateOfBirth("03/02/1990");
        addEmployeeCommand.setDateOfJoining("16/01/2018");
        addEmployeeCommand.setGender("M");
        addEmployeeCommand.setFirstName("Abhishek");
        addEmployeeCommand.setLastName("Patel");


        DelegateExecution execution = Mockito.mock(DelegateExecution.class);
        Mockito.when(execution.getVariable("command")).thenReturn(addEmployeeCommand);


        processAddEmployeeDelegate.execute(execution);

        Mockito.verify(execution).setVariable("result", 0L);
    }


}
