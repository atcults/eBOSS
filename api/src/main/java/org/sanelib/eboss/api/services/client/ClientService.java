package org.sanelib.eboss.api.services.client;

import org.sanelib.eboss.api.dto.client.ClientDTO;
import org.sanelib.eboss.api.services.ApiEndPointConstants;
import org.sanelib.eboss.api.services.ApiServiceBase;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.CLIENT_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class ClientService extends ApiServiceBase {

    @GET
    public List<ClientDTO> getAllClient() throws Exception{

        List<ClientDTO> list = new ArrayList<>();
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientId("CL001");
        clientDTO.setClientSecret("secret");
        clientDTO.setClientName("WEB");
        clientDTO.setDescription("Desciption");
        clientDTO.setClientUrl("url");
        clientDTO.setClientType("type");
        clientDTO.setScope("scope");
        clientDTO.setRedirectUri("redirect");
        clientDTO.setRegdate("2005/07/01");
        list.add(clientDTO);
        return list;
    }

    @POST
    public String addClient(ClientDTO clientDTO) throws Throwable {
        return execute(clientDTO, ActivitiProcessConstants.Admin.ADD_CLIENT);
    }

    @PUT
    public String updateClient(ClientDTO clientDTO) throws Throwable {
        return execute(clientDTO, ActivitiProcessConstants.Admin.UPDATE_CLIENT);
    }

}

