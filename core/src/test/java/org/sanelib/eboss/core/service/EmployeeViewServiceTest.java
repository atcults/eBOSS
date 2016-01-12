package org.sanelib.eboss.core.service;

import org.junit.Assert;
import org.junit.Test;
import org.sanelib.eboss.ViewIntegrationTestBase;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.domain.view.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class EmployeeViewServiceTest extends ViewIntegrationTestBase {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    ViewService viewService;

    @Override
    protected List<String> getTableNames() {
        return Collections.singletonList("employee");
    }

    @Override
    protected List<String> getSetupQueries() {
        String stmt = "INSERT INTO `eboss`.`employee` " +
                "(`code`, `firstName`, `middleName`, `lastName`, `dateOfBirth`, `addressLine1`, `addressLine2`, `city`, `state`, `country`, `zipCode`, `phone`, `email`, `gender`, `dateOfJoining`, `isActive`) " +
                "VALUES " +
                "('1', 'fn1', 'mn1', 'ln1', '1990-01-01 00:00:00', 'line1', 'line2', 'city1', 'state1', 'country1', '12345', '1234567890', 'a@b.com', 'M', '2014-01-01 00:00:00', 1)" +
                ", ('2', 'fn2', 'mn2', 'ln2', '1990-01-02 00:00:00', 'line11', 'line22', 'city2', 'state2', 'country2', '54321', '09876543210', 'b@a.com', 'F', '2014-01-02 00:00:00', 1)";
        return Collections.singletonList(stmt);
    }

    @Test
	public void loadEmployeesTest() throws Throwable {

        List<Employee> list = viewService.loadQuery("select * from employee", employeeMapper);

        Assert.assertEquals(list.size(), 2);

        for(Employee employee : list){
            if(Objects.equals(employee.getCode(), "2")){
                Assert.assertEquals("fn2", employee.getFirstName());
                Assert.assertEquals("mn2", employee.getMiddleName());
                Assert.assertEquals("ln2", employee.getLastName());
                Assert.assertEquals(DateHelper.constructDate(1990, 0, 2), employee.getDateOfBirth());
                Assert.assertEquals("line11", employee.getAddressLine1());
                Assert.assertEquals("line22", employee.getAddressLine2());
                Assert.assertEquals("city2", employee.getCity());
                Assert.assertEquals("state2", employee.getState());
                Assert.assertEquals("country2", employee.getCountry());
                Assert.assertEquals("54321", employee.getZipCode());
                Assert.assertEquals("09876543210", employee.getPhone());
                Assert.assertEquals("b@a.com", employee.getEmail());
                Assert.assertEquals("F", employee.getGender());
                Assert.assertEquals(DateHelper.constructDate(2014, 0, 2), employee.getDateOfJoining());
                Assert.assertEquals(true, employee.getIsActive());
            }
        }
    }
}
