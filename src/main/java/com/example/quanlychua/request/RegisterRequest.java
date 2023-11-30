package com.example.quanlychua.request;

import com.example.quanlychua.enums.QuyenHanEnums;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    @NotBlank(message = "Vui lòng điền username")
    @Size(min = 7, max = 18, message = "Độ dài username phải từ 7 đến 18 ký tự")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "Chỉ cho phép chữ và số")
    private String username;

    @NotBlank(message = "Vui lòng điền password")
    private String password;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Địa chỉ email không hợp lệ")
    private String email;

    @NotNull(message = "Không được để trống quyền hạn")
    private QuyenHanEnums quyenHanEnums;
}
