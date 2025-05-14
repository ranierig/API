package com.githubapi.githubapi.service;


import com.githubapi.githubapi.client.GitHubApiClient;
import com.githubapi.githubapi.dto.GitHubUsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitHubUserService {
    private final GitHubApiClient gitHubApiClient;

    @Autowired
    public GitHubUserService(GitHubApiClient gitHubApiClient) {
        this.gitHubApiClient = gitHubApiClient;
    }

    public List<GitHubUsersDTO> fetchUsers(Long since) {
        return gitHubApiClient.getUsers(since);
    }
}



