package org.sanelib.eboss.api.converters.employee;


import org.junit.Before;
import org.junit.Test;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.employee.AddEmployee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmployeeDTOConverterTest {

    EmployeeDTOConverter employeeDTOConverter;

    @Before
    public void setUp(){
        employeeDTOConverter = new EmployeeDTOConverter();
    }

    @Test
    public void testAddEmployeeSuccessExecute() throws Exception{
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeId("001");
        dto.setFirstName("firstName");
        ProcessCommand command = employeeDTOConverter.convert(dto);
        assertTrue("Wrong output " + command, command instanceof AddEmployee);
        AddEmployee addEmployee = (AddEmployee) command;
        assertEquals("Id is not mapped", dto.getEmployeeId(), addEmployee.getEmployeeId());
    }
}
