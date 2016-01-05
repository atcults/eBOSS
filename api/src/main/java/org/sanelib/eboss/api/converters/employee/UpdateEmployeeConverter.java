package org.sanelib.eboss.api.converters.employee;

import com.google.common.base.Strings;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.common.utils.ReflectionHelper;
import org.sanelib.eboss.common.utils.RegularExpressionHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.employee.AddEmployee;
import org.sanelib.eboss.core.commands.employee.UpdateEmployee;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateEmployeeConverter extends AddEmployeeConverter {

    @Override
    public ProcessCommand convert(EmployeeDTO dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddEmployee addEmployee = (AddEmployee) super.convert(dto, processError);

        UpdateEmployee updateEmployee = new UpdateEmployee();
        ReflectionHelper.copy(addEmployee, updateEmployee);

        if(Strings.isNullOrEmpty(dto.getId())){
            processError.addError("common.field.required", "id", "domain.employee.id");
        }else if(!RegularExpressionHelper.checkIdFormat(dto.getId())){
            processError.addError("common.field.pattern", "id", "domain.employee.id", RegularExpressionHelper.ID_FORMAT);
        } else {
            updateEmployee.setId(Integer.parseInt(dto.getId()));
        }

        return updateEmployee;
    }
}
