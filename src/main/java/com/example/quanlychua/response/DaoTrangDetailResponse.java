package com.example.quanlychua.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DaoTrangDetailResponse {

    private Integer id;

    private String noiDung;

    private String noiToChuc;

    private Integer soThanhVienThamGia;

    private String nguoiTruTri;

    private LocalDate thoiGianBatDau;
}
