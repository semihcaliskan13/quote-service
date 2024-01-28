package com.land.quotebackend.api.controller;

import com.land.quotebackend.dto.request.auth.AuthLoginRequest;
import com.land.quotebackend.dto.response.auth.AuthLoginResponse;
import com.land.quotebackend.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping
    public AuthLoginResponse login(@RequestBody AuthLoginRequest request) {
        return authService.login(request);
    }

    @PostMapping
    public void sigUp(){

    }
}
