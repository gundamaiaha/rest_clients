package com.example.orderservice.controller;

import com.example.orderservice.dto.GetTokenRequestDto;
import com.example.orderservice.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token/api/v1")
@RequiredArgsConstructor
public class TokenController {


    private final TokenService tokenService;


    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> getToken(final GetTokenRequestDto getTokenRequestDto) {
        return ResponseEntity.ok(tokenService.getToken(getTokenRequestDto));
    }


}
