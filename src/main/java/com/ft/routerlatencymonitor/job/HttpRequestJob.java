package com.ft.routerlatencymonitor.job;

import com.ft.routerlatencymonitor.httpclient.APIFTCOMClient;

public class HttpRequestJob implements Runnable {

    private APIFTCOMClient client;

    public HttpRequestJob(APIFTCOMClient client) {
        this.client = client;
    }

    @Override
    public void run() {
        client.makeHttpRequestsForLatencyMonitoring();
    }
}
