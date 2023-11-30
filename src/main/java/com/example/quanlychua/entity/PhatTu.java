package com.example.quanlychua.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "phattu")
public class PhatTu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "TenTaiKhoan")
    private String tenTaiKhoan;

    @Column(name = "AnhChup")
    private String anhChup;

    @Column(name = "DaHoanTuc")
    private Boolean daHoanTuc;

    @Column(name = "Email")
    private String email;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgayCapNhat")
    private LocalDate ngayCapNhat;

    @Column(name = "NgayHoanTuc")
    private LocalDate ngayHoanTuc;

    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "PhapDanh")
    private String phapDanh;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @ManyToOne
    @JoinColumn(name = "ChuaId")
    private Chua chua;

    @ManyToOne
    @JoinColumn(name = "QuyenHanId")
    @Enumerated(EnumType.STRING)
    @JsonBackReference
    private QuyenHan quyenHan;

    @OneToMany(mappedBy = "phatTu", fetch = FetchType.LAZY)
    private List<XacNhanEmail> xacNhanEmailList;

    @OneToMany(mappedBy = "phatTu", fetch = FetchType.LAZY)
    private List<BaiViet> baiVietList;

    @OneToMany(mappedBy = "phatTu", fetch = FetchType.LAZY)
    private List<NguoiDungThichBaiViet> nguoiDungThichBaiVietList;

    @OneToMany(mappedBy = "phatTu", fetch = FetchType.LAZY)
    private List<BinhLuanBaiViet> binhLuanBaiVietList;

    @OneToMany(mappedBy = "phatTu", fetch = FetchType.LAZY)
    private List<PhatTuDaoTrang> phatTuDaoTrangList;

    @OneToMany(mappedBy = "phatTu", fetch = FetchType.LAZY)
    private List<DonDangKy> donDangKyList;

    @OneToMany(mappedBy = "phatTu", fetch = FetchType.LAZY)
    private List<NguoiDungThichBinhLuanBaiViet> nguoiDungThichBinhLuanBaiVietList;

    @OneToMany(mappedBy = "phatTu", fetch = FetchType.LAZY)
    private List<RefreshToken> refreshTokenList;
}
