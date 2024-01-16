package com.land.quotebackend.service;

import com.land.quotebackend.dto.request.AuthLoginRequest;
import com.land.quotebackend.dto.response.AuthLoginResponse;

public interface AuthService {

    AuthLoginResponse login(AuthLoginRequest request);
}
