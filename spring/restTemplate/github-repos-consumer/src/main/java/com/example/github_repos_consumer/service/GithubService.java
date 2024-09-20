package com.example.github_repos_consumer.service;

import com.example.github_repos_consumer.dto.GitHubSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class GithubService {

    private final RestTemplate restTemplate;

    public GitHubSearchResponse search(String query) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.github.v3+json");

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        final String githubSearchUrl = "/search/repositories?q={query}";
        ResponseEntity<GitHubSearchResponse> response =
                restTemplate.exchange(githubSearchUrl, HttpMethod.GET,
                httpEntity, GitHubSearchResponse.class, query);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }
        else {
            throw new RuntimeException("Failed to search repositories: " + response.getStatusCode());
        }


    }

}
