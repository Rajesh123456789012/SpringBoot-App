package com.info.config.profile;

import org.springframework.core.env.Environment;

import java.util.Arrays;

public class ScheduleProfileCondition extends ProfileCondition {
    @Override
    protected boolean matchProfiles(Environment environment) {
        return Arrays.stream(environment.getActiveProfiles())
                .anyMatch(s -> s.endsWith("Schedule"));
    }
}
