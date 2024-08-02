package com.jobrun.jobrunbase;

import org.jobrunr.jobs.filters.JobFilter;
import org.jobrunr.jobs.filters.RetryFilter;

public class TermRetry extends RetryFilter implements JobFilter {
    private static final long INITIAL_BACKOFF_MS = 1000; // 1 segundo
    private static final long MAX_BACKOFF_MS = 10000; // 10 segundos
    private static final double BACKOFF_MULTIPLIER = 2.0;

    public TermRetry() {
        super(2); // Número máximo de reintentos
    }

}
