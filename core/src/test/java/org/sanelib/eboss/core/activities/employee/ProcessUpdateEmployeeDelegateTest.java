package org.sanelib.eboss.core.activities.employee;

import org.activiti.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.commands.employee.UpdateEmployee;
import org.sanelib.eboss.core.dao.EmployeeRepository;
import org.sanelib.eboss.core.domain.entity.Employee;

public class ProcessUpdateEmployeeDelegateTest {

    EmployeeRepository employeeRepositoryMock;

    ProcessUpdateEmployeeDelegate processUpdateEmployeeDelegate;

    @Before
    public void setUp(){
        employeeRepositoryMock = Mockito.mock(EmployeeRepository.class);
        processUpdateEmployeeDelegate = new ProcessUpdateEmployeeDelegate();
        processUpdateEmployeeDelegate.employeeRepository = employeeRepositoryMock;
    }

    @Test
    public void testAddEmployeeSuccessExecute() throws Exception {

        Mockito.doNothing().when(employeeRepositoryMock).save(Mockito.isA(Employee.class));

        UpdateEmployee updateEmployee = new UpdateEmployee();
        updateEmployee.setId(101l);
        updateEmployee.setCode("E101");
        updateEmployee.setFirstName("fName");
        updateEmployee.setMiddleName("mName");
        updateEmployee.setLastName("lName");
        updateEmployee.setDateOfBirth(DateHelper.constructDate(1990, 1, 1));
        updateEmployee.setAddressLine1("7,Shakti Park Soc");
        updateEmployee.setAddressLine2("College Road");
        updateEmployee.setCity("Nadiad");
        updateEmployee.setState("Gujarat");
        updateEmployee.setCountry("India");
        updateEmployee.setZipCode("387001");
        updateEmployee.setPhone("9876543210");
        updateEmployee.setEmail("fname@gmail.com");
        updateEmployee.setGender("Male");
        updateEmployee.setDateOfJoining(DateHelper.constructDate(2015, 7, 1));
        updateEmployee.setIsActive(true);

        DelegateExecution execution = Mockito.mock(DelegateExecution.class);
        Mockito.when(execution.getVariable("command")).thenReturn(updateEmployee);

      }

}
