package com.githubapi.githubapi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GitHubApiConfiguration {
    @Value("${api.url}")
    private String urlApi;
    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl(urlApi).build();
    }
}
