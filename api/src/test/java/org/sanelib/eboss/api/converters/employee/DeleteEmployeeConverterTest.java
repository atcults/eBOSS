package org.sanelib.eboss.api.converters.employee;


import org.junit.Test;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.employee.DeleteEmployee;
import org.sanelib.eboss.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteEmployeeConverterTest {

    @Test
    public void testDeleteEmployeeSuccessExecute() throws Exception{

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId("1");

        ProcessError processError= new ProcessError();

        DeleteEmployeeConverter deleteEmployeeConverter = new DeleteEmployeeConverter();
        ProcessCommand command = deleteEmployeeConverter.convert(employeeDTO , processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteEmployee);

        DeleteEmployee deleteEmployee = (DeleteEmployee) command;

        assertEquals("Id is not mapped", employeeDTO.getId(), String.valueOf(deleteEmployee.getId()));
    }

}
