package com.GitHubAPI.GitHubAPI.Services;

import com.GitHubAPI.GitHubAPI.Dto.DtoGitHubUsers;
import com.GitHubAPI.GitHubAPI.ProxyClientApi.GithubClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class ServiceGitHubUsers {
    RestTemplate restTemplate = new RestTemplate();
    private final String githubApiUrl = "https://api.github.com";
    public ServiceGitHubUsers(RestTemplate restTemplate) {
        this.restTemplate  = restTemplate;
    }
    public List<DtoGitHubUsers> getUsers(int since) {
        String url = githubApiUrl + "/users?since=" + since;
        DtoGitHubUsers[] users = restTemplate.getForObject(url, DtoGitHubUsers[].class);
        return Arrays.asList(users);
    }
}
