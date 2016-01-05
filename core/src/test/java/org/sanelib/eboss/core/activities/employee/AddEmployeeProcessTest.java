package org.sanelib.eboss.core.activities.employee;

import org.junit.Test;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.common.utils.RegularExpressionHelper;
import org.sanelib.eboss.BaseSpringJUnitTest;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.employee.AddEmployee;
import org.sanelib.eboss.core.domain.entity.Employee;

import static org.junit.Assert.*;

public class AddEmployeeProcessTest extends BaseSpringJUnitTest {

	@Test
	public void testAddEmployeeProcessTest() throws Throwable {
        AddEmployee addEmployee = new AddEmployee();
        addEmployee.setCode("101");
        addEmployee.setFirstName("fName");
        addEmployee.setMiddleName("mName");
        addEmployee.setLastName("lName");
        addEmployee.setDateOfBirth(DateHelper.constructDate(1990, 1, 1));
        addEmployee.setAddressLine1("7,Shakti Park Soc");
        addEmployee.setAddressLine2("College Road");
        addEmployee.setCity("Nadiad");
        addEmployee.setState("Gujarat");
        addEmployee.setCountry("India");
        addEmployee.setZipCode("387001");
        addEmployee.setPhone("+91-9876543210");
        addEmployee.setEmail("fname@gmail.com");
        addEmployee.setGender("Male");
        addEmployee.setDateOfJoining(DateHelper.constructDate(2015, 7 ,1));
        addEmployee.setIsActive(true);

        String result = execute(addEmployee, ActivitiProcessConstants.Admin.ADD_EMPLOYEE);

        assertNotNull(result);
        assertTrue(RegularExpressionHelper.checkIdFormat(result));

        Long id = Long.parseLong(result);

        Employee employee = load(Employee.class, id);

        assertNotNull(employee);

        assertEquals(addEmployee.getCode(), employee.getCode());
        assertEquals(addEmployee.getFirstName(),employee.getFirstName());
        assertEquals(addEmployee.getMiddleName(),employee.getMiddleName());
        assertEquals(addEmployee.getLastName(),employee.getLastName());
        assertEquals(addEmployee.getDateOfBirth(),employee.getDateOfBirth());
        assertEquals(addEmployee.getAddressLine1(),employee.getAddressLine1());
        assertEquals(addEmployee.getAddressLine2(),employee.getAddressLine2());
        assertEquals(addEmployee.getCity(),employee.getCity());
        assertEquals(addEmployee.getState(),employee.getState());
        assertEquals(addEmployee.getCountry(),employee.getCountry());
        assertEquals(addEmployee.getZipCode(),employee.getZipCode());
        assertEquals(addEmployee.getPhone(),employee.getPhone());
        assertEquals(addEmployee.getEmail(),employee.getEmail());
        assertEquals(addEmployee.getGender(),employee.getGender());
        assertEquals(addEmployee.getDateOfJoining(),employee.getDateOfJoining());
        assertEquals(addEmployee.getIsActive(),employee.getIsActive());

    }
}
