package com.eray.jwt.security.service;

import com.eray.jwt.security.dto.LoginRequest;
import com.eray.jwt.security.dto.TokenResponseDto;
import com.eray.jwt.security.exception.GenericException;
import com.eray.jwt.security.utils.TokenGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserService userService;
    private final TokenGenerator tokenGenerator;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserService userService, TokenGenerator tokenGenerator, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenGenerator = tokenGenerator;
        this.authenticationManager = authenticationManager;
    }

    public TokenResponseDto login(LoginRequest loginRequest) {
        try {
            Authentication auth = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
            return new TokenResponseDto(tokenGenerator.generateToken(auth), userService.getUser(loginRequest.getUsername()));
        } catch (Exception e) {
            throw new GenericException(HttpStatus.NOT_FOUND, "User not found!");
        }
    }
}
