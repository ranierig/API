package com.githubapi.githubapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GitHubApiExceptions extends RuntimeException {
    public GitHubApiExceptions(String message) {
        super(message);
    }
}
