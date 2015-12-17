package org.sanelib.eboss.api.services;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("org.sanelib.eboss.api.services");
    }
}
