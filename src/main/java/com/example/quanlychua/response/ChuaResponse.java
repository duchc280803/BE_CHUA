package com.example.quanlychua.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChuaResponse {

    private Integer id;

    private String tenChua;

    private String diaChi;

    private LocalDate ngayThanhLap;

    private String nguoiTruTri;

}

