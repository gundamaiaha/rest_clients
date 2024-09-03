package com.example.ordersservice.util;

import com.example.ordersservice.entity.Token;
import com.example.ordersservice.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenGenerator {

    private final TokenRepository tokenRepository;


    @Scheduled(fixedRate = 60000)
    void generateAndPersistToken(){
        log.info("deleting and generating the token");
        tokenRepository.deleteAll();
        Token token= new Token();
        token.setToken(UUID.randomUUID().toString());
        tokenRepository.save(token);
    }








}
