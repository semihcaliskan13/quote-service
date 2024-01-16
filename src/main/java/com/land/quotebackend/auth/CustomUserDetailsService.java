package com.land.quotebackend.auth;

import com.land.quotebackend.dto.UserCredential;
import com.land.quotebackend.entity.Role;
import com.land.quotebackend.entity.User;
import com.land.quotebackend.service.UserService;
import com.land.quotebackend.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;
    private final HttpServletRequest request;
    private final JwtUtil jwtUtil;

    public CustomUserDetailsService(UserService userService, HttpServletRequest request, JwtUtil jwtUtil) {
        this.userService = userService;
        this.request = request;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorization != null) {
            String token = jwtUtil.resolveToken(request);
            jwtUtil.tokenControl(token);
        }
        User user = userService.getUserByUsername(username);
        List<Role> roles = user.getRoles();
        return new CustomUserDetails(
                new UserCredential(
                        user.getId(),
                        user.getUsername(),
                        user.getPassword(),
                        roles
                ));
    }
}
