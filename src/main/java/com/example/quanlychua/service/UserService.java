package com.example.quanlychua.service;

import com.example.quanlychua.entity.RefreshToken;
import com.example.quanlychua.request.LoginRequest;
import com.example.quanlychua.request.RegisterRequest;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.response.TokenResponse;

import java.util.Optional;

public interface UserService {

    TokenResponse login(LoginRequest loginRequest);

    MessageResponse register(RegisterRequest registerRequest);

    RefreshToken createToken(String username);

    RefreshToken verifyExpiration(RefreshToken token);

    Optional<RefreshToken> findByToken(String token);

}
