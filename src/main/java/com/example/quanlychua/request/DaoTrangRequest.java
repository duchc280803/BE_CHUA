package com.example.quanlychua.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DaoTrangRequest {

    @NotBlank(message = "Không được để trống nội dung")
    private String noiDung;

    @NotBlank(message = "Không được để trống tiêu đề bài viết")
    private String noiToChuc;

    @Min(value = 0, message = "Số thành viên không được âm")
    private Integer soThanhVienThamGia;

    @NotBlank(message = "Không được để trống người trủ trì")
    private String nguoiTruTri;
}
