package org.sanelib.eboss.api.converters.employee;

import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.common.utils.RegularExpressionHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.employee.UpdateEmployee;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateEmployeeConverter extends AddEmployeeConverter {

    @Autowired
    ProcessError processError;

    @Override
    public ProcessCommand convert(EmployeeDTO dto) {
        UpdateEmployee command = (UpdateEmployee) super.convert(dto);

        if(RegularExpressionHelper.checkIdFormat(dto.getId())){
            processError.addError("common.field.required", "id", "domain.employee.id");
        } else {
            command.setId(Integer.parseInt(dto.getId()));
        }

        return command;
    }
}
