package com.githubapi.githubapi.client;

import com.githubapi.githubapi.dto.GitHubUsersDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
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
        try {
            GitHubUsersDTO[] users = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path(pathUrl)
                            .queryParam("since", since)
                            .build())
                    .retrieve()
                    .bodyToMono(GitHubUsersDTO[].class)
                    .block(); // Bloqueia até a resposta chegar (útil em apps não reativos)
            log.info("Quantidade retornada: {} usuários.", users.length);
            log.info("Último usuário: {}.", Arrays.asList(users).get(users.length - 1).id());
            return users != null ? Arrays.asList(users) : List.of();
        } catch (WebClientResponseException e) {
            log.error("Erro HTTP: {}", e.getStatusCode());
            return List.of();
        } catch (Exception e) {
            System.err.println("Erro geral: " + e.getMessage());
            return List.of();
        }
    }
}