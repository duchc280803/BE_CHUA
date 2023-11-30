package com.example.quanlychua.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaiVietResponse {

    private Integer idBaiViet;

    private String image;

    private String tieuDe;

    private String moTa;

    private String noiDung;

    private Integer soLuotThich;

    private Integer soLuotBinhLuan;
}
