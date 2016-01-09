package org.sanelib.eboss.api.converters.employee;

import org.sanelib.eboss.api.converters.ViewToDtoConverter;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.core.domain.view.Employee;

public class EmployeeDTOConverter implements ViewToDtoConverter<EmployeeDTO, Employee> {

    @Override
    public EmployeeDTO convert(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(String.valueOf(employee.getId()));
        dto.setCode(employee.getCode());
        return dto;
    }
}
