package com.githubapi.githubapi.controllers;

import com.githubapi.githubapi.dto.GitHubUsersDTO;
import com.githubapi.githubapi.service.GitHubUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("${mapping.url}")
public class GitHubUsersController {
    private final GitHubUserService gitHubUserService;
    public GitHubUsersController(GitHubUserService gitHubUserService) {
        log.info("Executando Controller.");
        this.gitHubUserService = gitHubUserService;
    }
    @GetMapping //("/users")
    public List<GitHubUsersDTO> getUsers(@RequestParam long since) {
    return gitHubUserService.fetchUsers(since);

    }
}
