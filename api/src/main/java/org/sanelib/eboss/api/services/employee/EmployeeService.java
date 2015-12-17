package org.sanelib.eboss.api.services.employee;

import org.activiti.engine.RuntimeService;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.api.services.ApiServiceBase;
import org.sanelib.eboss.core.activities.demo.FirstProcessDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path(EmployeeService.URL)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeService extends ApiServiceBase {

    public static final String URL = "/employee";

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    FirstProcessDelegate firstProcessDelegate;

    @Autowired
    RuntimeService runtimeService;

    @GET
    public List<EmployeeDTO> getAllEmployees() throws Exception {

        List<EmployeeDTO> dtos = new ArrayList<>();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName("first name");
        employeeDTO.setLastName("last name");
        dtos.add(employeeDTO);

        execute(employeeDTO, "helloWorldProcess");

        return dtos;
    }
}
