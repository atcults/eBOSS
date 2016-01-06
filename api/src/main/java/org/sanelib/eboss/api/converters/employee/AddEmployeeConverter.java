package org.sanelib.eboss.api.converters.employee;

import com.google.common.base.Strings;
import org.sanelib.eboss.api.converters.DtoToCommandConverter;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.common.utils.RegularExpressionHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.employee.AddEmployee;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddEmployeeConverter implements DtoToCommandConverter<EmployeeDTO> {

    @Override
    public ProcessCommand convert(EmployeeDTO dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddEmployee command = new AddEmployee();

        //Check code and convert
        if(Strings.isNullOrEmpty(dto.getCode())){
            processError.addError("common.field.required", "code", "domain.employee.code");
        }else{
            command.setCode(dto.getCode());
        }

        if(Strings.isNullOrEmpty(dto.getFirstName())){
            processError.addError("common.field.required", "firstName", "domain.employee.firstName");
        }else{
            command.setFirstName(dto.getFirstName());
        }

        command.setMiddleName(dto.getMiddleName());

        if(Strings.isNullOrEmpty(dto.getLastName())){
            processError.addError("common.field.required", "lastName", "domain.employee.lastName");
        }else{
            command.setLastName(dto.getLastName());
        }

        if(!RegularExpressionHelper.checkDateFormat(dto.getDateOfBirth())) {
            processError.addError("common.field.pattern", "date", "domain.customer.date", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        } else {
            command.setDateOfBirth(DateHelper.fromDateString(dto.getDateOfBirth()));
        }

        command.setAddressLine1(dto.getAddressLine1());
        command.setAddressLine2(dto.getAddressLine2());
        command.setCity(dto.getCity());
        command.setState(dto.getState());
        command.setCountry(dto.getCountry());
        command.setZipCode(dto.getZipCode());

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getPhone())) {
            processError.addError("common.field.pattern", "phone", "domain.customer.phone", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        } else {
            command.setPhone(dto.getPhone());
        }

        if(!RegularExpressionHelper.checkEmailFormat(dto.getEmail())) {
            processError.addError("common.field.pattern", "email", "domain.customer.email", RegularExpressionHelper.EMAIL_FORMAT_EXAMPLE);
        } else {
            command.setEmail(dto.getEmail());
        }

        command.setGender(dto.getGender());

        if(!RegularExpressionHelper.checkDateFormat(dto.getDateOfJoining())) {
            processError.addError("common.field.pattern", "date", "domain.customer.date", RegularExpressionHelper.DATE_FORMAT_EXAMPLE);
        } else {
            command.setDateOfJoining(DateHelper.fromDateString(dto.getDateOfJoining()));
        }

        command.setIsActive(dto.getIsActive());

        return command;
    }
}
