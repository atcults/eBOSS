package org.sanelib.eboss.api.converters.employee;

import org.sanelib.eboss.api.converters.ConverterHelper;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.common.utils.ReflectionHelper;
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

        ConverterHelper.checkIdRequired(dto, updateEmployee, processError);

        return updateEmployee;
    }
}
