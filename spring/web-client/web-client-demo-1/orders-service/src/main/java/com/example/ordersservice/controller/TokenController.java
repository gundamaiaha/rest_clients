package com.example.ordersservice.controller;

import com.example.ordersservice.dto.GetTokenRequest;
import com.example.ordersservice.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/token/api/v1")
public class TokenController {

    private final TokenService tokenService;


    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> getToken(GetTokenRequest getTokenRequest) {
        return ResponseEntity.ok(tokenService.getToken(getTokenRequest));
    }
}
