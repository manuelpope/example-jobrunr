package com.jobrun.jobrunbase;

import org.jobrunr.configuration.JobRunr;
import org.jobrunr.jobs.filters.RetryFilter;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.sql.common.SqlStorageProviderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class JobRunConf {

    @Bean
    public StorageProvider storageProvider(DataSource dataSource) {
        String schema = "tu_esquema";
        String tablePrefix = "tu_prefijo_";

        return SqlStorageProviderFactory
                .using(dataSource, "TEST.test_");
    }

    @Bean
    @Primary
    public JobScheduler jobScheduler(StorageProvider storageProvider) {
        return JobRunr
                .configure()
                .withJobFilter(new RetryFilter(3, 5))
                .useStorageProvider(storageProvider)
                .useBackgroundJobServer()
                .useDashboard()
                .initialize().getJobScheduler();
    }
}
