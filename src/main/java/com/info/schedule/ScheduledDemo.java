package com.info.schedule;

import com.info.config.profile.ScheduleProfileCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@Slf4j
//@Conditional(value = {ScheduleProfileCondition.class})
@Profile("devSchedule")
public class ScheduledDemo {

    @Scheduled(fixedRateString = "${schedule.time}")
    public void run(){
        log.info("START:: schedule");
        for (int i =1; i<= 10; i++){
            System.out.println("***********:: Scheduler :: ********::"+i);
        }
    }
}
