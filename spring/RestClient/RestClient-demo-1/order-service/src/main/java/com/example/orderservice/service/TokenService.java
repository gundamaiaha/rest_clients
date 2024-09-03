package com.example.orderservice.service;

import com.example.orderservice.dto.GetTokenRequestDto;
import com.example.orderservice.entity.Token;
import com.example.orderservice.exception.InvalidCredentialsException;
import com.example.orderservice.exception.NoTokensFoundException;
import com.example.orderservice.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TokenService {


    @Value("${client.id}")
    private String clientId;

    @Value("${client.secret}")
    private String clientSecret;

    private final TokenRepository tokenRepository;


    public String getToken(final GetTokenRequestDto getTokenRequest) {
        if (clientId.equals(getTokenRequest.getClientId()) && clientSecret.equals(getTokenRequest.getClientSecret())) {
            List<Token> tokens = tokenRepository.findAll();
            if (tokens.isEmpty()) {
                throw new NoTokensFoundException("No tokens found");
            }
            return tokens.get(0).getToken();
        }
        throw new InvalidCredentialsException("Credentials are not valid");
    }


}
