package com.example.quanlychua.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "baiviet")
public class BaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "LoaiBaiVietId")
    private LoaiBaiViet loaiBaiViet;

    @Column(name = "image")
    private String image;

    @Column(name = "TieuDe")
    private String tieuDe;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "NoiDung")
    private String noiDung;

    @ManyToOne
    @JoinColumn(name = "PhatTuId")
    private PhatTu phatTu;

    @Column(name = "SoLuotThich")
    private Integer soLuotThich;

    @Column(name = "SoLuotBinhLuan")
    private Integer soLuotBinhLuan;

    @Column(name = "ThoiGianDang")
    private LocalDate thoiGianDang;

    @Column(name = "ThoiGianCapNhat")
    private LocalDate thoiGianCapNhat;

    @Column(name = "ThoiGianXoa")
    private LocalDate thoiGianXoa;

    @Column(name = "DaXoa")
    private Boolean daXoa;

    @ManyToOne
    @JoinColumn(name = "TrangThaiBaiVietId")
    private TrangThaiBaiViet trangThaiBaiViet;

    @OneToMany(mappedBy = "baiViet", fetch = FetchType.LAZY)
    private List<NguoiDungThichBaiViet> nguoiDungThichBaiVietList;

    @OneToMany(mappedBy = "baiViet", fetch = FetchType.LAZY)
    private List<BinhLuanBaiViet> binhLuanBaiVietList;
}
