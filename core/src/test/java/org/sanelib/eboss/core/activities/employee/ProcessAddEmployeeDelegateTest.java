package org.sanelib.eboss.core.activities.employee;

import org.activiti.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sanelib.eboss.common.utils.DateHelper;
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
        addEmployeeCommand.setCode("101");
        addEmployeeCommand.setFirstName("fName");
        addEmployeeCommand.setMiddleName("mName");
        addEmployeeCommand.setLastName("lName");
        addEmployeeCommand.setDateOfBirth(DateHelper.constructDate(1990, 1, 1));
        addEmployeeCommand.setAddressLine1("7,Shakti Park Soc");
        addEmployeeCommand.setAddressLine2("College Road");
        addEmployeeCommand.setCity("Nadiad");
        addEmployeeCommand.setState("Gujarat");
        addEmployeeCommand.setCountry("India");
        addEmployeeCommand.setZipCode("387001");
        addEmployeeCommand.setPhone("9876543210");
        addEmployeeCommand.setEmail("fname@gmail.com");
        addEmployeeCommand.setGender("Male");
        addEmployeeCommand.setDateOfJoining(DateHelper.constructDate(2015, 7 ,1));
        addEmployeeCommand.setIsActive(true);

        DelegateExecution execution = Mockito.mock(DelegateExecution.class);
        Mockito.when(execution.getVariable("command")).thenReturn(addEmployeeCommand);

        processAddEmployeeDelegate.execute(execution);

        Mockito.verify(execution).setVariable("result", 0L);
    }
}
