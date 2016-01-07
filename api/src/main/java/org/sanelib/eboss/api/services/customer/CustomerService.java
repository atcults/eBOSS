package org.sanelib.eboss.api.services.customer;


import org.sanelib.eboss.api.dto.customer.CustomerDTO;
import org.sanelib.eboss.api.services.ApiEndPointConstants;
import org.sanelib.eboss.api.services.ApiServiceBase;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.CUSTOMER_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerService extends ApiServiceBase {

    @GET
    public List<CustomerDTO> getAllCustomer() throws Exception{
        List<CustomerDTO> dtos = new ArrayList<>();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Megha Patel");
        customerDTO.setContactPersonName("Priya Mehta");
        customerDTO.setAddress("2, Soft Colony, Mangrol, Gujarat");
        customerDTO.setCountry("India");
        customerDTO.setPhone("+91-9876543210");
        customerDTO.setEmail("megh@yahoo.com");
        customerDTO.setFax("76543211");
        customerDTO.setWebsite("www.google.com");
        customerDTO.setNotes("New Customer");
        dtos.add(customerDTO);
        return dtos;
    }

    @POST
    public String addCustomer(CustomerDTO customerDTO) throws Throwable {
        return execute(customerDTO, ActivitiProcessConstants.Admin.ADD_CUSTOMER);
    }

    @PUT
    public String updateCustomer(CustomerDTO customerDTO) throws Throwable {
        return execute(customerDTO, ActivitiProcessConstants.Admin.UPDATE_CUSTOMER);
    }

    @DELETE
    @Path("/{id}")
    public String deleteCustomer(@PathParam("id") String id) throws Throwable {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(id);
        return execute(customerDTO, ActivitiProcessConstants.Admin.DELETE_CUSTOMER);
    }

}
