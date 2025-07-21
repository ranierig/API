package com.githubapi.githubapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@Slf4j
public class GitHubApiApplication {
    public static void main(String[] args) {
        log.info("------ Iniciando aplicação ------");
        SpringApplication.run(GitHubApiApplication.class, args);
    }
}
