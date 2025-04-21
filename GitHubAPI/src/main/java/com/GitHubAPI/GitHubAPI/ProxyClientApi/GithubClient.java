package com.GitHubAPI.GitHubAPI.ProxyClientApi;


import com.GitHubAPI.GitHubAPI.Dto.DtoGitHubUsers;
import com.GitHubAPI.GitHubAPI.Services.AppConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

@Service
public class GithubClient {

    private final RestTemplate restTemplate = new RestTemplate();;
    private final String githubApiUrl = "https://api.github.com";

  //  public GithubService(RestTemplate restTemplate) {
 //       this.restTemplate = restTemplate;
 //   }

    public List<DtoGitHubUsers> getUsers(int since) {
        String url = githubApiUrl + "/users?since=" + since;
        DtoGitHubUsers[] users = restTemplate.getForObject(url, DtoGitHubUsers[].class);
        return Arrays.asList(users);
    }
}



