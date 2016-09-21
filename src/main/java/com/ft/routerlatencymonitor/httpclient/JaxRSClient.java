package com.ft.routerlatencymonitor.httpclient;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class JaxRSClient implements APIFTCOMClient {

    public void makeHttpRequestsForLatencyMonitoring() {

        for (String endpoint : ENDPOINTS_TO_GET) {

            WebTarget webTarget = ClientBuilder
                    .newClient()
                    .target(endpoint)
                    .queryParam("apiKey", MASHERY_API_KEY);

            Response response = webTarget.request().get();
            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
        }
    }
}
