package org.sanelib.eboss.api.converters.employee;

import com.google.common.base.Strings;
import org.sanelib.eboss.api.converters.DtoToCommandConverter;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.employee.UpdateEmployee;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateEmployeeConverter extends AddEmployeeConverter {

    @Autowired
    ProcessError processError;

    //TODO: Need to validate number and convert id value
    @Override
    public ProcessCommand convert(EmployeeDTO dto) {
        UpdateEmployee command = (UpdateEmployee) super.convert(dto);
        //command.setId(dto.getId());
        return command;
    }
}
