package org.sanelib.eboss.api.converters.employee;

import org.sanelib.eboss.api.converters.DtoToCommandConverter;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.employee.AddEmployee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDTOConverter_NotUsed implements DtoToCommandConverter<EmployeeDTO> {

    @Override
    public ProcessCommand convert(EmployeeDTO dto) {
        AddEmployee command = new AddEmployee();
        command.setEmployeeId(Integer.valueOf(dto.getEmployeeId()));
        command.setFirstName(dto.getFirstName());
        command.setLastName(dto.getLastName());
        command.setGender(dto.getGender());
        command.setDateOfBirth(dto.getDateOfBirth());
        command.setDateOfJoining(dto.getDateOfJoining());
        return command;
    }
}
