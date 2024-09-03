package com.example.orderservice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetTokenRequestDto {
    private final String clientId;
    private final String clientSecret;
}
