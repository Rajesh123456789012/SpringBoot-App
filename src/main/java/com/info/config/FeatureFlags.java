package com.info.config;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Setter
@Configuration
@ConfigurationProperties(prefix = "feature-flags")
@Slf4j
public class FeatureFlags {

    public static boolean TTL_ENABLED;
    public static boolean MESSAGE_PACK_ENABLED;

    private Boolean ttlEnabled;
    private Boolean messagePackEnabled;

    @PostConstruct
    public void print(){
        TTL_ENABLED = ttlEnabled;
        MESSAGE_PACK_ENABLED = messagePackEnabled;
        log.info("************ :: feature flags:: *******::: {}", MESSAGE_PACK_ENABLED+" "+TTL_ENABLED);

    }
}

