package com.example.quanlychua.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {

    @NotBlank(message = "Không được để trống username")
    private String username;

    @NotBlank(message = "Không được để trống password")
    private String password;
}
