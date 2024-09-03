package com.example.orderservice.util;

import com.example.orderservice.entity.Token;
import com.example.orderservice.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TokenGenerator {

    private final TokenRepository tokenRepository;

    @Scheduled(fixedRate = 60000)
    void generateAndPersistToken() {
        tokenRepository.deleteAll();
        Token token = new Token();
        token.setToken(UUID.randomUUID().toString());
        tokenRepository.save(token);
    }


}
