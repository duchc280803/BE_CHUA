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
public class DonDangKyResponse {

    private Integer id;

    private LocalDate ngayGuiDon;

    private LocalDate ngayXuLy;

    private String nguoiXuLy;

    private String trangThai;
}
