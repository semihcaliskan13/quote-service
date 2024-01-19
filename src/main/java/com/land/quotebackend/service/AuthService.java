package com.land.quotebackend.service;

import com.land.quotebackend.dto.request.auth.AuthLoginRequest;
import com.land.quotebackend.dto.response.auth.AuthLoginResponse;

public interface AuthService {

    AuthLoginResponse login(AuthLoginRequest request);
}
