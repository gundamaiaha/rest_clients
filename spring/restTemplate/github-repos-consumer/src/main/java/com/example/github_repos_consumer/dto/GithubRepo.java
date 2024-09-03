package com.example.github_repos_consumer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubRepo {
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    private Owner owner;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Owner {
        private String login;
    }

}
