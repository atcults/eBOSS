package org.sanelib.eboss.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/")
public class HelloService {

    @Value("${message:eBOSS API server is running}")
    private String msg;

    @GET
    public String message() {
        return this.msg;
    }
}
