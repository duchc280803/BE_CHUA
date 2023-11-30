package com.example.quanlychua.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "daotrang")
public class DaoTrang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "DaKetThuc")
    private Boolean daKetThuc;

    @Column(name = "NoiDung")
    private String noiDung;

    @Column(name = "NoiToChuc")
    private String noiToChuc;

    @Column(name = "SoThanhVienThamGiaMax")
    private Integer soThanhVienThamGiaMax;

    @Column(name = "SoThanhVienThamGia")
    private Integer soThanhVienThamGia;

    @Column(name = "ThoiGianBatDau")
    private LocalDate thoiGianBatDau;

    @Column(name = "NguoiTruTri")
    private String nguoiTruTri;

    @OneToMany(mappedBy = "daoTrang", fetch = FetchType.LAZY)
    private List<PhatTuDaoTrang> phatTuDaoTrangList;

    @OneToMany(mappedBy = "daoTrang", fetch = FetchType.LAZY)
    private List<DonDangKy> donDangKyList;

}
