package com.example.quanlychua.controller;

import com.example.quanlychua.entity.RefreshToken;
import com.example.quanlychua.jwt.JwtService;
import com.example.quanlychua.model.UserCustomDetails;
import com.example.quanlychua.request.LoginRequest;
import com.example.quanlychua.request.RegisterRequest;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.response.PhatTuResponse;
import com.example.quanlychua.response.TokenResponse;
import com.example.quanlychua.service.impl.PhatTuServiceImpl;
import com.example.quanlychua.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthenticationController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PhatTuServiceImpl phatTuService;

    @PostMapping("login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<MessageResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(userService.register(registerRequest), HttpStatus.CREATED);
    }

    // TODO: phương thức có nhiệm vụ cập nhật token.
    @PostMapping("refresh-token")
    public ResponseEntity<TokenResponse> refreshToken(@RequestBody RefreshToken refreshToken) {
        try {
            // tìm user thông qua token
            TokenResponse response = userService.findByToken(refreshToken.getToken())
                    .map(userService::verifyExpiration) // nếu tìm thấy user sẽ gọi hàm very...
                    .map(RefreshToken::getPhatTu) // lấy ra thông tin phật tử
                    .map(phatTu -> {
                        String accessToken = jwtService.generateToken(new UserCustomDetails(phatTu));
                        return TokenResponse.builder()
                                .accessToken(accessToken)
                                .token(refreshToken.getToken())
                                .build();
                    }).orElseThrow(() -> new RuntimeException(
                            "Refresh token is not in database!"));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("all/{name}")
    public ResponseEntity<PhatTuResponse> getAll(@PathVariable("name") String name) {
        return new ResponseEntity<>(phatTuService.getList(name), HttpStatus.OK);
    }
}