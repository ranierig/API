package com.githubapi.githubapi.service;

import com.githubapi.githubapi.client.GitHubApiClient;
import com.githubapi.githubapi.dto.GitHubUsersDTO;
import com.githubapi.githubapi.exceptions.GitHubApiExceptionsModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GitHubUserService {
    private final GitHubApiClient gitHubApiClient;

    @Autowired
    public GitHubUserService(GitHubApiClient gitHubApiClient) {
        this.gitHubApiClient = gitHubApiClient;
    }

    public List<GitHubUsersDTO> fetchUsers(Long since) {
        log.info("Executando Serviço usuário inicial: {}.", since + 1);
        return gitHubApiClient
                .getUsers(since)
                ;
    }
}



