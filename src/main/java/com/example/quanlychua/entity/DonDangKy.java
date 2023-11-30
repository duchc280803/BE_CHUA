package com.example.quanlychua.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dondangky")
public class DonDangKy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "NgayGuiDon")
    private LocalDate ngayGuiDon;

    @Column(name = "NgayXuLy")
    private LocalDate ngayXuLy;

    @Column(name = "NguoiXuLy")
    private Integer nguoiXuLy;

    @ManyToOne
    @JoinColumn(name = "TrangThaiDonId")
    private TrangThaiDon trangThaiDon;

    @ManyToOne
    @JoinColumn(name = "DaoTrangId")
    private DaoTrang daoTrang;

    @ManyToOne
    @JoinColumn(name = "PhatTuId")
    private PhatTu phatTu;

}
