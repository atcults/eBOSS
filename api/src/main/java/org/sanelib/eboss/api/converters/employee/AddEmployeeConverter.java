package org.sanelib.eboss.api.converters.employee;

import com.google.common.base.Strings;
import org.sanelib.eboss.api.converters.DtoToCommandConverter;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.employee.AddEmployee;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddEmployeeConverter implements DtoToCommandConverter<EmployeeDTO> {

    @Autowired
    ProcessError processError;

    @Override
    public ProcessCommand convert(EmployeeDTO dto) {
        AddEmployee command = new AddEmployee();

        //Check code and convert
        if(Strings.isNullOrEmpty(dto.getCode())){
            processError.addError("common.field.required", "code", "domain.employee.code");
        }else{
            command.setCode(dto.getCode());
        }

        command.setFirstName(dto.getFirstName());
        command.setMiddleName(dto.getMiddleName());
        command.setLastName(dto.getLastName());
        command.setDateOfBirth(DateHelper.fromDateString(dto.getDateOfBirth()));
        command.setAddressLine1(dto.getAddressLine1());
        command.setAddressLine2(dto.getAddressLine2());
        command.setCity(dto.getCity());
        command.setState(dto.getState());
        command.setCountry(dto.getCountry());
        command.setZipCode(dto.getZipCode());
        command.setPhone(dto.getPhone());
        command.setEmail(dto.getEmail());
        command.setGender(dto.getGender());
        command.setDateOfJoining(DateHelper.fromDateString(dto.getDateOfJoining()));
        command.setIsActive(dto.getIsActive());
        return command;
    }
}
