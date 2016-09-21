package com.ft.routerlatencymonitor;

import com.ft.routerlatencymonitor.config.RouterLatencyMonitorConfig;
import com.ft.routerlatencymonitor.httpclient.APIFTCOMClient;
import com.ft.routerlatencymonitor.httpclient.DropwizardInstrumentedClient;
import com.ft.routerlatencymonitor.job.HttpRequestJob;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.lifecycle.setup.ScheduledExecutorServiceBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;
import java.util.concurrent.TimeUnit;

public class RouterLatencyMonitorMain extends Application<RouterLatencyMonitorConfig> {

    @Override
    public void initialize(Bootstrap<RouterLatencyMonitorConfig> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor()
                )
        );

    }

    @Override
    public void run(final RouterLatencyMonitorConfig routerLatencyMonitorConfig,
                    final Environment environment) throws Exception {

        final Client client = new JerseyClientBuilder(environment)
                .using(routerLatencyMonitorConfig.getJerseyClientConfiguration())
                .build("ak-testing");

//        environment.jersey().register(new ExternalServiceResource(client));

        APIFTCOMClient apiftcomClient = new DropwizardInstrumentedClient(client);

        ScheduledExecutorServiceBuilder scheduledExecutorServiceBuilder = environment
                                                                            .lifecycle()
                                                                            .scheduledExecutorService("scheduler");
        scheduledExecutorServiceBuilder.build().scheduleAtFixedRate(
                new HttpRequestJob(apiftcomClient),
                routerLatencyMonitorConfig.getSchedulerConfig().getInitialDelayInSeconds(),
                routerLatencyMonitorConfig.getSchedulerConfig().getPeriodInSeconds(),
                TimeUnit.SECONDS);
    }

    public static void main(String[] args) {

        try {
            new RouterLatencyMonitorMain().run("server", RouterLatencyMonitorMain.class.getClassLoader().getResource("config.yaml").getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
