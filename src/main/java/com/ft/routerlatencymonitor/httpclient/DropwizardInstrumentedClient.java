package com.ft.routerlatencymonitor.httpclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class DropwizardInstrumentedClient implements APIFTCOMClient {

    private static final Logger log = LoggerFactory.getLogger(DropwizardInstrumentedClient.class);
    private Client[] clients;

    public DropwizardInstrumentedClient(Client masheryClient, final Client fastlyRouterClient) {
        clients = new Client[]{masheryClient, fastlyRouterClient};
    }

    @Override
    public void makeHttpRequestsForLatencyMonitoring() {

        for (int i=0; i<clients.length; i++) {

            Client client = clients[i];
            String[] endpointsToGet = ENDPOINTS_TO_GET[i];

            for (String endpoint: endpointsToGet) {

                WebTarget webTarget = client
                        .target(endpoint)
                        .queryParam("apiKey", MASHERY_API_KEY);

                Response response = webTarget.request().get();
                log.info("endpoint={} statuse={}", response.getStatus());
            }
        }
    }
}
