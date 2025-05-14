package com.githubapi.githubapi.client;

import com.githubapi.githubapi.dto.GitHubUsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Component
public class GitHubApiClient {

    private static final String GITHUB_API_URL = "https://api.github.com/users";

    private final RestTemplate restTemplate;

    @Autowired
    public GitHubApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GitHubUsersDTO> getUsers(Long since) {
        String url = UriComponentsBuilder.fromHttpUrl(GITHUB_API_URL)
                .queryParam("since", since)
                .toUriString();

        GitHubUsersDTO[] users = restTemplate.getForObject(url, GitHubUsersDTO[].class);
        return users != null ? Arrays.asList(users) : List.of();
    }
}
