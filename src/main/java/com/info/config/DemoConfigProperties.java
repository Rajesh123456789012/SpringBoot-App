package com.info.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "demo-service")
@Getter
@Setter
public class DemoConfigProperties {

    private String baseUrl;
    private String baseUri;

    private final DemoConfigProperties.Transaction transaction = new DemoConfigProperties.Transaction();

    @Getter
    @Setter
    public static class Transaction {
        private String resourceUri;
        private Integer timeout;
    }
}
