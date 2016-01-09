package org.sanelib.eboss.core.service;

import org.junit.Assert;
import org.junit.Test;
import org.sanelib.eboss.ViewIntegrationTestBase;
import org.sanelib.eboss.core.domain.view.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

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
                "('1', 'fn1', 'mn1', 'ln1', '1990-01-01 00:00:00', '', '', '', '', '', '', '', '', '', '1990-01-01 00:00:00', 1)" +
                ", ('2', 'fn1', 'mn1', 'ln1', '1990-01-01 00:00:00', '', '', '', '', '', '', '', '', '', '1990-01-01 00:00:00', 1)";
        return Collections.singletonList(stmt);
    }

    @Test
	public void testAddEmployeeProcessTest() throws Throwable {

        List<Employee> list = viewService.loadQuery("select * from employee", employeeMapper);

        Assert.assertEquals(list.size(), 2);

        for(Employee e : list){
            System.out.println(e);
        }
    }
}
