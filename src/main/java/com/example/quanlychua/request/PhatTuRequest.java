package com.example.quanlychua.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhatTuRequest {

    @NotBlank(message = "Pháp danh không được trống")
    private String phapDanh;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Địa chỉ email không hợp lệ")
    @NotBlank(message = "Email không được trống")
    private String email;

    private LocalDate ngaySinh;

    @Pattern(regexp = "\\d{10}", message = "Số điện thoại phải có 10 chữ số")
    private String soDienThoai;

    @NotBlank(message = "Giới tính không được trống")
    private String gioiTinh;

}
