package com.example.github_repos_consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GitHubSearchResponse {
    private List<GithubRepo> items; // <1>
}
