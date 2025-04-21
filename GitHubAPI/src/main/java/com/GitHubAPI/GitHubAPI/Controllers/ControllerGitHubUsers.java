package com.GitHubAPI.GitHubAPI.Controllers;
import com.GitHubAPI.GitHubAPI.Dto.DtoGitHubUsers;
import com.GitHubAPI.GitHubAPI.Services.ServiceGitHubUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerGitHubUsers {

    ServiceGitHubUsers githubService;

    public ControllerGitHubUsers(ServiceGitHubUsers githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/api/users")
    public List<DtoGitHubUsers> getUsers(@RequestParam int since) {
        return githubService.getUsers(since);
    }
}
