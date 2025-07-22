package com.githubapi.githubapi.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GitHubApiExceptionsGlobal {

    @ExceptionHandler(GitHubApiExceptions.class)
    public ResponseEntity<GitHubApiExceptionsModel> tratarUsuarioNaoEncontrado(
            GitHubApiExceptions ex,
            HttpServletRequest request) {
        log.error("Usuário não encontrado: {}", ex.getMessage(), ex);
        GitHubApiExceptionsModel erro = new GitHubApiExceptionsModel(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Usuário não encontrado",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GitHubApiExceptionsModel> tratarErroGeral(Exception ex,
                                                                    HttpServletRequest request) {
        log.error("Erro inesperado na requisição {}: {}", request.getRequestURI(), ex.getMessage(), ex);
        GitHubApiExceptionsModel erro = new GitHubApiExceptionsModel(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erro interno",
                "Ocorreu um erro inesperado",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}