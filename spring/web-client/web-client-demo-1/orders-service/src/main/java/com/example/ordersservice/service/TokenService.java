package com.example.ordersservice.service;

import com.example.ordersservice.dto.GetTokenRequest;
import com.example.ordersservice.entity.Token;
import com.example.ordersservice.exception.InvalidCredentialsException;
import com.example.ordersservice.exception.NoTokenFoundException;
import com.example.ordersservice.repository.TokenRepository;
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


    public String getToken(final GetTokenRequest getTokenRequest) {
        if (clientId.equals(getTokenRequest.getClientId()) &&
                clientSecret.equals(getTokenRequest.getClientSecret())) {
            List<Token> tokens = tokenRepository.findAll();

            if (tokens.isEmpty()) {
                throw new NoTokenFoundException("No tokens found");
            }
            return tokens.get(0).getToken();
        }

        throw new InvalidCredentialsException("Credentials are not valid");
    }

}
