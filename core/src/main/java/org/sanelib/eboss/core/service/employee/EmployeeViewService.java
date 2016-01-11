package org.sanelib.eboss.core.service.employee;

import org.sanelib.eboss.core.domain.view.Employee;
import org.sanelib.eboss.core.service.EmployeeMapper;
import org.sanelib.eboss.core.service.ViewService;
import org.sanelib.eboss.core.service.ViewServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class EmployeeViewService extends ViewServiceBase {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    ViewService viewService;

    @Override
    protected List<String> getStatements() {
        return Collections.singletonList("select * from employee");
    }

   public List<Employee> getAll() throws Throwable {
        return viewService.loadQuery(getStatements().get(0), employeeMapper);
    }
}


