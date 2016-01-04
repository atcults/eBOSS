package org.sanelib.eboss.core.activities.employee;

import org.junit.Test;
import org.sanelib.eboss.common.utils.RegularExpressionHelper;
import org.sanelib.eboss.BaseSpringJUnitTest;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.employee.AddEmployee;
import org.sanelib.eboss.core.domain.entity.Employee;

import static org.junit.Assert.*;

public class AddEmployeeProcessTest extends BaseSpringJUnitTest {

	@Test
	public void testAddEmployeeProcessTest() throws Throwable {
        AddEmployee addEmployee= new AddEmployee();
        addEmployee.setCode("EMP001");
        addEmployee.setFirstName("First Name");
        addEmployee.setLastName("Last Name");
        addEmployee.setCountry("India");
        addEmployee.setPhone("+91-9876543210");
        addEmployee.setEmail("name@yahoo.com");

        String result = execute(addEmployee, ActivitiProcessConstants.Admin.ADD_EMPLOYEE);

        assertNotNull(result);
        assertTrue(RegularExpressionHelper.checkIdFormat(result));

        Long id = Long.parseLong(result);

        Employee employee = load(Employee.class, id);

        assertNotNull(employee);

        assertEquals(addEmployee.getCode(), addEmployee.getCode());

    }
}
