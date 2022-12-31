package com.info.config.profile;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public abstract class ProfileCondition extends SpringBootCondition {
    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if (matchProfiles(context.getEnvironment())){
            return ConditionOutcome.match("A local profile matched.");
        }
        return ConditionOutcome.match("Not matched profile.");
    }

    protected abstract boolean matchProfiles(final Environment environment);
}
