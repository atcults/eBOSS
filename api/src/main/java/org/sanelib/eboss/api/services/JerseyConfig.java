package org.sanelib.eboss.api.services;

import org.glassfish.jersey.server.ResourceConfig;
import org.sanelib.eboss.api.services.employee.EmployeeService;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        //packages("org.sanelib.eboss.api.services");
        register(HelloService.class);
        register(EmployeeService.class);

    }
}
