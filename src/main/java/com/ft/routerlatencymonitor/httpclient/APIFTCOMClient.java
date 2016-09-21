package com.ft.routerlatencymonitor.httpclient;

public interface APIFTCOMClient {

    String MASHERY_API_KEY = System.getenv("mashery-api-key");
    String[][] ENDPOINTS_TO_GET =
        {
                {
                    "https://api.ft.com/content/ab56d13a-81b6-11e5-8095-ed1a37d1e096",
                    "http://api.ft.com/content/items/v1/74e76e08-67bc-11da-bfce-0000779e2340",
                    "http://api.ft.com/t800/a"
                },
                {
                    "https://beta-api.ft.com/content/ab56d13a-81b6-11e5-8095-ed1a37d1e096",
                    "http://beta-api.ft.com/content/items/v1/74e76e08-67bc-11da-bfce-0000779e2340",
                    "http://beta-api.ft.com/t800/a"
                }
        };

    void makeHttpRequestsForLatencyMonitoring();
}
