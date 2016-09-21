package com.ft.routerlatencymonitor;

import com.ft.routerlatencymonitor.httpclient.APIFTCOMClient;
import com.ft.routerlatencymonitor.httpclient.JaxRSClient;
import org.junit.Test;

public class JaxRSClientImplementationTest {

    @Test
    public void testExecute() throws Exception {

        APIFTCOMClient apiftcomClient = new JaxRSClient();
        apiftcomClient.makeHttpRequestsForLatencyMonitoring();
    }
}