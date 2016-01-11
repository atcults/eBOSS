package org.sanelib.eboss.core.service;

import org.sanelib.eboss.core.domain.view.Employee;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class EmployeeMapper implements ViewMapper<Employee> {

    public Employee map(final DataResultSet rs) throws SQLException {

        final String viewName = "employee";
        final Employee employee = new Employee();
        employee.setId(rs.getLong(viewName, "id"));
        employee.setCode(rs.getString(viewName, "code"));
        employee.setFirstName(rs.getString(viewName, "firstName"));
        employee.setMiddleName(rs.getString(viewName, "middleName"));
        employee.setLastName(rs.getString(viewName, "lastName"));
        employee.setDateOfBirth(rs.getDate(viewName, "dateOfBirth"));
        employee.setAddressLine1(rs.getString(viewName, "addressLine1"));
        employee.setAddressLine2(rs.getString(viewName, "addressLine2"));
        employee.setCity(rs.getString(viewName, "city"));
        employee.setState(rs.getString(viewName, "state"));
        employee.setCountry(rs.getString(viewName, "country"));
        employee.setZipCode(rs.getString(viewName, "zipCode"));
        employee.setPhone(rs.getString(viewName, "phone"));
        employee.setEmail(rs.getString(viewName, "email"));
        employee.setGender(rs.getString(viewName, "gender"));
        employee.setDateOfJoining(rs.getDate(viewName, "dateOfJoining"));
        employee.setIsActive(rs.getBoolean(viewName, "isActive"));
        return employee;
    }
}

