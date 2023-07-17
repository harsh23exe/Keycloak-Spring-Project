package com.Spring_project.Keycloackuser.frontend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/* This file serves for http request to keycloak */
@Configuration
public class RestConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
