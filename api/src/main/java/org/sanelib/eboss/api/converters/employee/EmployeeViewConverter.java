package org.sanelib.eboss.api.converters.employee;

import org.sanelib.eboss.api.converters.ViewToDtoConverter;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.domain.view.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeViewConverter implements ViewToDtoConverter<EmployeeDTO, Employee> {

    @Override
    public EmployeeDTO convert(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(String.valueOf(employee.getId()));
        dto.setCode(employee.getCode());
        dto.setFirstName(employee.getFirstName());
        dto.setMiddleName(employee.getMiddleName());
        dto.setLastName(employee.getLastName());
        dto.setDateOfBirth(DateHelper.toDateString(employee.getDateOfBirth()));
        dto.setAddressLine1(employee.getAddressLine1());
        dto.setAddressLine2(employee.getAddressLine2());
        dto.setCity(employee.getCity());
        dto.setState(employee.getState());
        dto.setZipCode(employee.getZipCode());
        dto.setPhone(employee.getPhone());
        dto.setEmail(employee.getEmail());
        dto.setGender(employee.getGender());
        dto.setDateOfJoining(DateHelper.toDateString(employee.getDateOfJoining()));
        dto.setIsActive(employee.getIsActive());
        return dto;
    }
}