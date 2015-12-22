package org.sanelib.eboss.api.services.employee;

import org.activiti.engine.RuntimeService;
import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.api.services.ApiEndPointConstants;
import org.sanelib.eboss.api.services.ApiServiceBase;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.EMPLOYEE_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeService extends ApiServiceBase {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    RuntimeService runtimeService;

    @GET
    public List<EmployeeDTO> getAllEmployees() throws Exception {
        List<EmployeeDTO> dtos = new ArrayList<>();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId("EMP001");
        employeeDTO.setFirstName("first name");
        employeeDTO.setLastName("last name");
        employeeDTO.setDateOfJoining("2015-12-31");
        employeeDTO.setDateOfBirth("1991-01-01");
        dtos.add(employeeDTO);
        return dtos;
    }

    @POST
    public String addEmployee(EmployeeDTO employeeDTO) throws Exception {
        return execute(employeeDTO, ActivitiProcessConstants.Admin.ADD_EMPLOYEE_PROCESS);
    }
}
