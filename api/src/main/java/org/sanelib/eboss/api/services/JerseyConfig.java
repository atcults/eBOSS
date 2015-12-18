package org.sanelib.eboss.api.services;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.sanelib.eboss.api.errorhandling.AppExceptionMapper;
import org.sanelib.eboss.api.errorhandling.GenericExceptionMapper;
import org.sanelib.eboss.api.errorhandling.NotFoundExceptionMapper;
import org.sanelib.eboss.api.filters.CORSResponseFilter;
import org.sanelib.eboss.api.filters.LoggingResponseFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        packages("org.sanelib.eboss.api.services");

        //register exception handling
        register(GenericExceptionMapper.class);
        register(AppExceptionMapper.class);
        register(NotFoundExceptionMapper.class);

        //register filters
        register(LoggingResponseFilter.class);
        register(CORSResponseFilter.class);

        //register features
        register(JacksonFeature.class);
        register(MultiPartFeature.class);
    }
}
