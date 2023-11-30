package com.example.quanlychua.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenResponse {

    private String accessToken;

    private String token;

    private String message;
}
