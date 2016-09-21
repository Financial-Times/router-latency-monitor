package com.ft.routerlatencymonitor.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class RouterLatencyMonitorConfig extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("jerseyClient")
    private JerseyClientConfiguration jerseyClientConfiguration = new JerseyClientConfiguration();

    @JsonProperty("scheduler")
    private SchedulerConfig schedulerConfig = new SchedulerConfig();

    public JerseyClientConfiguration getJerseyClientConfiguration() {
        return jerseyClientConfiguration;
    }

    public SchedulerConfig getSchedulerConfig() {
        return schedulerConfig;
    }
}
