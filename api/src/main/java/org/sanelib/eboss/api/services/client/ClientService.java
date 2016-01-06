package org.sanelib.eboss.api.services.client;

import org.sanelib.eboss.api.dto.client.ClientDTO;
import org.sanelib.eboss.api.services.ApiEndPointConstants;
import org.sanelib.eboss.api.services.ApiServiceBase;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
        clientDTO.setClient_secret("secret");
        clientDTO.setClient_name("WEB");
        clientDTO.setDescription("Desciption");
        clientDTO.setClient_url("url");
        clientDTO.setClient_type("type");
        clientDTO.setScope("scope");
        clientDTO.setRedirect_uri("redirect");
        clientDTO.setRegdate("2005/07/01");
        list.add(clientDTO);
        return list;
    }

    @POST
    public String addClient(ClientDTO clientDTO) throws Throwable {
        return execute(clientDTO, ActivitiProcessConstants.Admin.ADD_CLIENT);
    }

}

