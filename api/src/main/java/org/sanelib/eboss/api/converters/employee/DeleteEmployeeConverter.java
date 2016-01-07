package org.sanelib.eboss.api.converters.employee;

import org.sanelib.eboss.api.converters.ConverterHelper;
import org.sanelib.eboss.api.converters.DtoToCommandConverter;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.employee.DeleteEmployee;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteEmployeeConverter implements DtoToCommandConverter<EmployeeDTO> {
    public ProcessCommand convert(EmployeeDTO dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        DeleteEmployee command=new DeleteEmployee();
        ConverterHelper.checkIdRequired(dto, command, processError);

       return command;
    }
}
