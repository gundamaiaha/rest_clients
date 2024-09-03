package com.example.github_repos_consumer.controller;

import com.example.github_repos_consumer.dto.GitHubSearchResponse;
import com.example.github_repos_consumer.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/github-repos")
public class GithubRepoSearchController {

    private final GithubService githubService;



    @GetMapping("/search/{query}")
    public GitHubSearchResponse search(@PathVariable  String query) {
        return githubService.search(query);
    }

}
