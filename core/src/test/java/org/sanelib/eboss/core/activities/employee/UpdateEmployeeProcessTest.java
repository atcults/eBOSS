package org.sanelib.eboss.core.activities.employee;


import org.junit.Test;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.EntityIntegrationTestBase;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.employee.UpdateEmployee;
import org.sanelib.eboss.core.domain.entity.Employee;

import java.util.Date;

import static org.junit.Assert.*;

public class UpdateEmployeeProcessTest extends EntityIntegrationTestBase {

    @Test
    public void testUpdateEmployeeProcessTest() throws Throwable {

        Date dateOfBirth = DateHelper.constructDate(1990, 2, 2);
        Date dateOfJoining = DateHelper.constructDate(2015, 6 ,2);

        Employee employee = new Employee();
        employee.setFirstName("Fname");
        employee.setCode("E102");
        employee.setFirstName("FName");
        employee.setMiddleName("MName");
        employee.setLastName("LName");
        employee.setDateOfBirth(dateOfBirth);
        employee.setAddressLine1("8,Shakti Park Soc");
        employee.setAddressLine2("College Road");
        employee.setCity("Nadiad");
        employee.setState("Gujarat");
        employee.setCountry("India");
        employee.setZipCode("387001");
        employee.setPhone("+91-9876543210");
        employee.setEmail("fname@gmail.com");
        employee.setGender("Male");
        employee.setDateOfJoining(dateOfJoining);
        employee.setIsActive(true);

        persist(employee);

        UpdateEmployee update = new UpdateEmployee();
        update.setId(employee.getId());
        update.setCode("NewEmpCode");
        update.setFirstName("NewFName");
        update.setMiddleName("NewMName");
        update.setLastName("NewLName");
        update.setDateOfBirth(dateOfBirth);
        update.setAddressLine1("New Address1");
        update.setAddressLine2("New Address2");
        update.setCity("New City");
        update.setState("New State");
        update.setCountry("New Country");
        update.setZipCode("387001");
        update.setPhone("+91-9876543210");
        update.setEmail("newfname@gmail.com");
        update.setGender("Male");
        update.setDateOfJoining(dateOfJoining);
        update.setIsActive(true);

        String result = execute(update, ActivitiProcessConstants.Admin.UPDATE_EMPLOYEE);

        assertNull(result);

        assertNotNull(update);

        assertEquals("NewEmpCode", update.getCode());
        assertEquals("NewFName",update.getFirstName());
        assertEquals("NewMName",update.getMiddleName());
        assertEquals("NewLName",update.getLastName());
        assertEquals(dateOfBirth, employee.getDateOfBirth());
        assertEquals("New Address1",update.getAddressLine1());
        assertEquals("New Address2",update.getAddressLine2());
        assertEquals("New City",update.getCity());
        assertEquals("New State",update.getState());
        assertEquals("New Country",update.getCountry());
        assertEquals("387001",update.getZipCode());
        assertEquals("+91-9876543210",update.getPhone());
        assertEquals("newfname@gmail.com",update.getEmail());
        assertEquals("Male",update.getGender());
        assertEquals(dateOfJoining, employee.getDateOfJoining());
        assertTrue(update.getIsActive());

    }

}
