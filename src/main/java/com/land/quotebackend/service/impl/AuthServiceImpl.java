package com.land.quotebackend.service.impl;

import com.land.quotebackend.auth.CustomUserDetails;
import com.land.quotebackend.dto.UserCredential;
import com.land.quotebackend.dto.request.AuthLoginRequest;
import com.land.quotebackend.dto.response.AuthLoginResponse;
import com.land.quotebackend.entity.User;
import com.land.quotebackend.service.AuthService;
import com.land.quotebackend.service.UserService;
import com.land.quotebackend.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(JwtUtil jwtUtil, UserService userService, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthLoginResponse login(AuthLoginRequest request) {
        String username = request.username();
        var authentication = new UsernamePasswordAuthenticationToken(username,request.password());
        try {
            var auth = authenticationManager.authenticate(authentication);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return generateToken(username);
    }

    private AuthLoginResponse generateToken(String username) {
        User user = userService.getUserByUsername(username);
        UserCredential userCredential = new UserCredential(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
        );
        var userDetails = new CustomUserDetails(userCredential);
        String token = jwtUtil.generateToken(userDetails);
        return new AuthLoginResponse(
                token
        );

    }
}
