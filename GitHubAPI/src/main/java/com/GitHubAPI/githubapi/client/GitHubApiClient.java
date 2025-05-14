package com.githubapi.githubapi.client;

import com.githubapi.githubapi.dto.GitHubUsersDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Component
public class GitHubApiClient {

    private final WebClient webClient;

    public GitHubApiClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<GitHubUsersDTO> getUsers(long since) {
        GitHubUsersDTO[] users = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/users")
                        .queryParam("since", since)
                        .build())
                .retrieve()
                .bodyToMono(GitHubUsersDTO[].class)
                .block(); // Bloqueia até a resposta chegar (útil em apps não reativos)

        return users != null ? Arrays.asList(users) : List.of();
    }
}