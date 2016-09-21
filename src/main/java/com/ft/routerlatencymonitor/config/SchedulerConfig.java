package com.ft.routerlatencymonitor.config;

public class SchedulerConfig {

    int periodInSeconds;
    int initialDelayInSeconds;

    public int getPeriodInSeconds() {
        return periodInSeconds;
    }

    public void setPeriodInSeconds(final int periodInSeconds) {
        this.periodInSeconds = periodInSeconds;
    }

    public int getInitialDelayInSeconds() {
        return initialDelayInSeconds;
    }

    public void setInitialDelayInSeconds(final int initialDelayInSeconds) {
        this.initialDelayInSeconds = initialDelayInSeconds;
    }
}
