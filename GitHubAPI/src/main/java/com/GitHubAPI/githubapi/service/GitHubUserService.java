package com.githubapi.githubapi.service;


import com.githubapi.githubapi.client.GitHubApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import com.githubapi.githubapi.dto.GitHubUsersDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitHubUserService {
    private final GitHubApiClient gitHubApiClient ;

    @Autowired
    public GitHubUserService(GitHubApiClient gitHubApiClient) {
        this.gitHubApiClient = gitHubApiClient;
        gitHubApiClient = null;
    }

    public List<GitHubUsersDTO> fetchUsers(Long  since) {
//        String githubApiUrl = "https://api.github.com";
//        String url = githubApiUrl + "/users?since=" + since;
//        System.out.println(url);
//        GitHubUsersDTO[] users = restTemplate.getForObject(url, GitHubUsersDTO[].class);
        return gitHubApiClient.getUsers(since);
    }
}



