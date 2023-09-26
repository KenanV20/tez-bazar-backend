package com.ads.advertisement.controller;

import com.ads.advertisement.dto.AuthenticationDto;
import com.ads.advertisement.dto.requests.AuthRequestDto;
import com.ads.advertisement.dto.requests.UserRegisterRequestDto;
import com.ads.advertisement.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationDto> register(
            @RequestBody UserRegisterRequestDto requestDto
    ) {
        return ResponseEntity.ok(authService.register(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationDto> register(
            @RequestBody AuthRequestDto authRequestDto
    ) {
        return ResponseEntity.ok(authService.authenticate(authRequestDto));
    }
}