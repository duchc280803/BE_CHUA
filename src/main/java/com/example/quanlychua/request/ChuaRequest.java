package com.example.quanlychua.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChuaRequest {

    @NotBlank(message = "Không được để trống tên chùa")
    private String tenChua;

    @NotBlank(message = "Không được để trống địa chỉ")
    private String diaChi;

    @NotBlank(message = "Không được để trống người trủ trì")
    private String nguoiTruTri;

}
