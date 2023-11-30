package com.example.quanlychua.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaiVietRequest {

    @NotBlank(message = "Không được để trống tiêu đề bài viết")
    private String tieuDeBaiViet;

    @NotBlank(message = "Không được để trống nội dùng")
    private String noiDung;

    @NotBlank(message = "Không được để trống mô tả")
    private String mota;

    @NotBlank(message = "Không được để trống loại bài viết")
    private String loaiBaiViet;

}
