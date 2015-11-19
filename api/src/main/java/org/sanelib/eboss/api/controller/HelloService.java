package org.sanelib.eboss.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/")
public class HelloService {

    private Service service;

    @Autowired
    public HelloService(Service service) {
        this.service = service;
    }

    @GET
    public String message() {
        System.out.println("HelloService Message is called :" + System.getProperty("spring.profiles.active"));
        return "Hello " + this.service.message();
    }
}
