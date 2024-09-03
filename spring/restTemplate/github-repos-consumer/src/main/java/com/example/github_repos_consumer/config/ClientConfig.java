package com.example.github_repos_consumer.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {

    public static final String GITHUB_API_BASE_URL = "https://api.github.com";


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .rootUri(GITHUB_API_BASE_URL)
                .build();
    }

}
