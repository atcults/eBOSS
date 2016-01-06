package org.sanelib.eboss.api.converters.employee;


import org.junit.Test;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.employee.UpdateEmployee;
import org.sanelib.eboss.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateEmployeeConverterTest {

    @Test
    public void testUpdateEmployeeSuccessExecute() throws Exception{
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId("1");
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
        dto.setPhone("+91-9876543210");
        dto.setEmail("fname@gmail.com");
        dto.setGender("Male");
        dto.setDateOfJoining("2015/07/01");
        dto.setIsActive(true);

        ProcessError processError = new ProcessError();

        UpdateEmployeeConverter updateEmployeeConverter = new UpdateEmployeeConverter();
        ProcessCommand command = updateEmployeeConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateEmployee);
        UpdateEmployee updateEmployee = (UpdateEmployee) command;
        assertEquals("Id is not mapped", dto.getId(), Long.toString(updateEmployee.getId()));
        assertEquals("Code is not mapped", dto.getCode(), updateEmployee.getCode());
        assertEquals("firstName is not mapped", dto.getFirstName(), updateEmployee.getFirstName());
        assertEquals("middleName is not mapped", dto.getMiddleName(), updateEmployee.getMiddleName());
        assertEquals("lastName is not mapped", dto.getLastName(), updateEmployee.getLastName());
        assertEquals("dateOfBirth is not mapped", dto.getDateOfBirth(), DateHelper.toDateString(updateEmployee.getDateOfBirth()));
        assertEquals("AddressLine1 is not mapped", dto.getAddressLine1(), updateEmployee.getAddressLine1());
        assertEquals("AddressLine2 is not mapped", dto.getAddressLine2(), updateEmployee.getAddressLine2());
        assertEquals("City is not mapped", dto.getCity(), updateEmployee.getCity());
        assertEquals("State is not mapped", dto.getState(), updateEmployee.getState());
        assertEquals("Country is not mapped", dto.getCountry(), updateEmployee.getCountry());
        assertEquals("ZipCode is not mapped", dto.getZipCode(), updateEmployee.getZipCode());
        assertEquals("Phone is not mapped", dto.getPhone(), updateEmployee.getPhone());
        assertEquals("Email is not mapped", dto.getEmail(), updateEmployee.getEmail());
        assertEquals("Gender is not mapped", dto.getGender(), updateEmployee.getGender());
        assertEquals("DateOfJoining is not mapped", dto.getDateOfJoining(), DateHelper.toDateString(updateEmployee.getDateOfJoining()));
        assertEquals("isActive is not mapped", dto.getIsActive(), updateEmployee.getIsActive());
    }

}
