package com.ft.routerlatencymonitor.httpclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class DropwizardInstrumentedClient implements APIFTCOMClient {

    private Client client;

    public DropwizardInstrumentedClient(Client client) {
        this.client = client;
    }

    @Override
    public void makeHttpRequestsForLatencyMonitoring() {

        for (String endpoint: APIFTCOMClient.ENDPOINTS_TO_GET) {

            WebTarget webTarget = client
                    .target(endpoint)
                    .queryParam("apiKey", MASHERY_API_KEY);

            Response response = webTarget.request().get();
            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
        }
    }
}
