package org.sanelib.eboss.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Service {

    @Value("${message:eBOSS API server is running}")
    private String msg;

    public String message() {
        return this.msg;
    }
}
