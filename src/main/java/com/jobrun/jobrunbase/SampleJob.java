package com.jobrun.jobrunbase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.jobs.annotations.Job;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class SampleJob {


    @Job(name = "The sample job with variable %0")
    public void executeSampleJob(String variable, int sleep) throws Exception {

        log.info("starting >> " + variable);
        Thread.sleep(sleep);

        if (sleep % 3 == 0) {
            log.error("bad " + variable);
            throw new RuntimeException("something goes wrong");
        }
        log.info("finish  a job >>  " + variable);


    }

}


