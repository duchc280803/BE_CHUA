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
public class DaoTrangResponse {

    private Integer id;

    private LocalDate thoiGianBd;

    private Boolean thoiGianKt;

    private String nguoiChuTri;

    private String noiToChuc;

    private Integer soThanhVienMax;

    private Integer soThanhVienThamGia;

}
