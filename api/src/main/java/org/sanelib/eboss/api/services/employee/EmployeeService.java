package org.sanelib.eboss.api.services.employee;

import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.api.services.ApiEndPointConstants;
import org.sanelib.eboss.api.services.ApiServiceBase;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.service.ViewNameConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.EMPLOYEE_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeService extends ApiServiceBase {

    @GET
    public List getAllEmployees() throws Throwable {
        return fetchAll(ViewNameConstants.Admin.EMPLOYEE);
    }

    @POST
    public String addEmployee(EmployeeDTO employeeDTO) throws Throwable {
        return execute(employeeDTO, ActivitiProcessConstants.Admin.ADD_EMPLOYEE);
    }

    @PUT
    public String updateEmployee(EmployeeDTO employeeDTO) throws Throwable {
        return execute(employeeDTO, ActivitiProcessConstants.Admin.UPDATE_EMPLOYEE);
    }

    @DELETE
    @Path("/{id}")
    public String deleteEmployee(@PathParam("id") String id) throws Throwable {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(id);
        return execute(employeeDTO, ActivitiProcessConstants.Admin.DELETE_EMPLOYEE);
    }
}
