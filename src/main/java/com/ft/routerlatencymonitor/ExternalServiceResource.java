package com.ft.routerlatencymonitor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;

@Path("/foo")
//@Timed
public class ExternalServiceResource {

    private final Client client;

    public ExternalServiceResource(Client client) {
        this.client = client;
    }

    @GET
    public String doStuff() {
        return "bar";
    }
}
