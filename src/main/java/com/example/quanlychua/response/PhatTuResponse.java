package com.example.quanlychua.response;

import com.example.quanlychua.enums.QuyenHanEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhatTuResponse {

    private Integer id;

    private LocalDate ngaySinh;

    private String username;

    private String password;

    private String gioiTinh;

    private String phapDanh;

    private String soDienThoai;

    private String email;

    private QuyenHanEnums role;
}
