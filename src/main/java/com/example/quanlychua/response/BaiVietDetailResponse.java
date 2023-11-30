package com.example.quanlychua.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaiVietDetailResponse {

    private Integer id;

    private String tenNguoiDung;

    private String image;

    private String tenBaiViet;

    private String noiDung;

    private Integer soLuotThich;

    private Integer soLuotBinhLuan;

}
