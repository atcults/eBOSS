package org.sanelib.eboss.api.converters.employee;

import org.junit.Before;
import org.junit.Test;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.employee.AddEmployee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddEmployeeConverterTest {

    AddEmployeeConverter addEmployeeConverter;

    @Before
    public void setUp(){
        addEmployeeConverter = new AddEmployeeConverter();
    }

    @Test
    public void testAddEmployeeSuccessExecute() throws Exception{
        EmployeeDTO dto = new EmployeeDTO();
        dto.setCode("001");
        dto.setFirstName("fName");
        dto.setMiddleName("mName");
        dto.setLastName("lName");
        dto.setDateOfBirth("1990/01/01");
        dto.setAddressLine1("7,Shakti Park Soc");
        dto.setAddressLine2("College Road");
        dto.setCity("Nadiad");
        dto.setState("Gujarat");
        dto.setCountry("India");
        dto.setZipCode("387001");
        dto.setPhone("9876543210");
        dto.setEmail("fname@gmail.com");
        dto.setGender("Male");
        dto.setDateOfJoining("2015/07/01");
        dto.setIsActive(true);
        ProcessCommand command = addEmployeeConverter.convert(dto);
        assertTrue("Wrong output " + command, command instanceof AddEmployee);
        AddEmployee addEmployee = (AddEmployee) command;
        assertEquals("Code is not mapped", dto.getCode(), addEmployee.getCode());
        assertEquals("firstName is not mapped", dto.getFirstName(), addEmployee.getFirstName());
        assertEquals("middleName is not mapped", dto.getMiddleName(), addEmployee.getMiddleName());
        assertEquals("lastName is not mapped", dto.getLastName(), addEmployee.getLastName());
        assertEquals("dateOfBirth is not mapped", dto.getDateOfBirth(), DateHelper.toDateString(addEmployee.getDateOfBirth()));
        assertEquals("AddressLine1 is not mapped", dto.getAddressLine1(), addEmployee.getAddressLine1());
        assertEquals("AddressLine2 is not mapped", dto.getAddressLine2(), addEmployee.getAddressLine2());
        assertEquals("City is not mapped", dto.getCity(), addEmployee.getCity());
        assertEquals("State is not mapped", dto.getState(), addEmployee.getState());
        assertEquals("Country is not mapped", dto.getCountry(), addEmployee.getCountry());
        assertEquals("ZipCode is not mapped", dto.getZipCode(), addEmployee.getZipCode());
        assertEquals("Phone is not mapped", dto.getPhone(), addEmployee.getPhone());
        assertEquals("Email is not mapped", dto.getEmail(), addEmployee.getEmail());
        assertEquals("Gender is not mapped", dto.getGender(), addEmployee.getGender());
        assertEquals("DateOfJoining is not mapped", dto.getDateOfJoining(), DateHelper.toDateString(addEmployee.getDateOfJoining()));
        assertEquals("isActive is not mapped", dto.getIsActive(), addEmployee.getIsActive());
    }
}
