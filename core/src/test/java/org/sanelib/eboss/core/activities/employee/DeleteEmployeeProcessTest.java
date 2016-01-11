package org.sanelib.eboss.core.activities.employee;

import org.junit.Test;
import org.sanelib.eboss.EntityIntegrationTestBase;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.employee.DeleteEmployee;
import org.sanelib.eboss.core.domain.entity.Employee;

import static org.junit.Assert.assertNull;

public class DeleteEmployeeProcessTest extends EntityIntegrationTestBase {

    @Test
    public void testDeleteEmployeeSuccess() throws Throwable {

        Employee employee = new Employee();
        employee.setCode("102");
        employee.setFirstName("fName");
        employee.setMiddleName("mName");
        employee.setLastName("lName");
        employee.setDateOfBirth(DateHelper.constructDate(1990, 1, 1));
        employee.setAddressLine1("7,Shakti Park Soc");
        employee.setAddressLine2("College Road");
        employee.setCity("Nadiad");
        employee.setState("Gujarat");
        employee.setCountry("India");
        employee.setZipCode("387001");
        employee.setPhone("+91-9876543210");
        employee.setEmail("fname@gmail.com");
        employee.setGender("Male");
        employee.setDateOfJoining(DateHelper.constructDate(2015, 7 ,1));
        employee.setIsActive(true);

        persist(employee);

        DeleteEmployee deleteEmployee = new DeleteEmployee();
        deleteEmployee.setId(employee.getId());

        String result = execute(deleteEmployee, ActivitiProcessConstants.Admin.DELETE_EMPLOYEE);
        assertNull(result);

        Employee deletedEmployee = fetch(Employee.class,employee.getId());
        assertNull(deletedEmployee);
    }
}
