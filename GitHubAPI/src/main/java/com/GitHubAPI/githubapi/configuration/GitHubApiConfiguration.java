package com.githubapi.githubapi.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
@Slf4j
@Configuration
public class GitHubApiConfiguration {
    @Value("${api.url}")
    private String urlApi;
    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        log.info("Executando o WebClient.");
        return builder.baseUrl(urlApi).build();
    }
}
