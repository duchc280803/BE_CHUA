package com.example.quanlychua.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "binhluanbaiviet")
public class BinhLuanBaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "BaiVietId")
    private BaiViet baiViet;

    @ManyToOne
    @JoinColumn(name = "PhatTuId")
    private PhatTu phatTu;

    @Column(name = "BinhLuan")
    private String binhLuan;

    @Column(name = "SoLuotThich")
    private Integer soLuotThich;

    @Column(name = "ThoiGianTao")
    private LocalDate thoiGianTao;

    @Column(name = "ThoiGianCapNhat")
    private LocalDate thoiGianCapNhat;

    @Column(name = "ThoiGianXoa")
    private LocalDate thoiGianXoa;

    @Column(name = "DaXoa")
    private Boolean daXoa;

    @OneToMany(mappedBy = "binhLuanBaiViet", fetch = FetchType.LAZY)
    private List<NguoiDungThichBinhLuanBaiViet> nguoiDungThichBinhLuanBaiVietList;

}
