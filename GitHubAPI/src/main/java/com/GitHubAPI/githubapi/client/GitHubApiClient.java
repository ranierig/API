package com.githubapi.githubapi.client;

import com.githubapi.githubapi.dto.GitHubUsersDTO;
import com.githubapi.githubapi.exceptions.GitHubApiExceptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class GitHubApiClient {
    @Value("${path.url}")
    private String pathUrl;
    private final WebClient webClient;

    public GitHubApiClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<GitHubUsersDTO> getUsers(long since) {
        log.info("Criando Lista.");
        GitHubUsersDTO[] users = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(pathUrl)
                        .queryParam("since", since)
                        .build())
                .retrieve()
                .bodyToMono(GitHubUsersDTO[].class)
                .onErrorMap(WebClientResponseException.class, ex ->
                        new GitHubApiExceptions("Erro da API GitHub: " + ex.getStatusCode()))
                .block(); // Bloqueia até a resposta chegar (útil em apps não reativos)
        assert users != null;
        log.info("Quantidade retornada: {} usuários.", users.length);
        log.info("Último usuário: {}.", Arrays.asList(users).get(users.length - 1).id());
        return users != null ? Arrays.asList(users) : List.of();
    }
}