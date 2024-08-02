package com.jobrun.jobrunbase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import static java.util.UUID.randomUUID;

@AllArgsConstructor
@Service
@Slf4j
public class JobTest implements CommandLineRunner {
    private JobScheduler jobScheduler;
    private SampleJob sampleJob;


    @Override
    public void run(String... args) throws Exception {

        var ui1 = randomUUID();
        var ui2 = randomUUID();
        var ui3 = randomUUID();
        var ui4 = randomUUID();
        var ui5 = randomUUID();
        var ui6 = randomUUID();

        var status = jobScheduler.enqueue(ui1, () -> sampleJob.executeSampleJob("10 " + ui1, 5000));
        log.info(status.toString());
        status = jobScheduler.enqueue(ui2, () -> sampleJob.executeSampleJob("2 " + ui2, 5000));
        log.info(status.toString());
        status = jobScheduler.enqueue(ui3, () -> sampleJob.executeSampleJob("5 " + ui3, 500));
        log.info(status.toString());
        status = jobScheduler.enqueue(ui4, () -> sampleJob.executeSampleJob("25 " + ui4, 15000));
        log.info(status.toString());
        status = jobScheduler.enqueue(ui5, () -> sampleJob.executeSampleJob("35 " + ui5, 3000));
        log.info(status.toString());
//
//        status = jobScheduler.schedule(ui6,LocalDateTime.now().plusMinutes(1L), () -> sampleJob.executeSampleJob("60 "+ui6, 3500));
//        log.info(status.toString());

    }
}
