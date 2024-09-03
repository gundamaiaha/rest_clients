package com.example.ordersservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTokenRequest {
    private String clientId;
    private String clientSecret;
}
