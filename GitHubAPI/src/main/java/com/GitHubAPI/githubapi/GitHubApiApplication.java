package com.githubapi.githubapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication

public class GitHubApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitHubApiApplication.class, args);
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl("https://api.github.com").build();
    }
}
