package org.sanelib.eboss.api.services.user;

import org.activiti.engine.RuntimeService;
import org.sanelib.eboss.api.dto.user.UserDTO;
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
@Path(ApiEndPointConstants.Admin.USER_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class UserService extends ApiServiceBase {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    RuntimeService runtimeService;

    @GET
    public List<UserDTO> getAllUsers() throws Exception {

        List<UserDTO> list = new ArrayList<>();

        UserDTO userDTO = new UserDTO();

        userDTO.setId("001");
        userDTO.setUsername("firstUser");
        userDTO.setPassword("password");

        list.add(userDTO);

        return list;
    }

    @POST
    public String addUser(UserDTO userDTO) throws Throwable {
        return execute(userDTO, ActivitiProcessConstants.Admin.ADD_USER);
    }
}
