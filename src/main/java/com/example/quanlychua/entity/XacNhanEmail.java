package com.example.quanlychua.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "xacnhanemail")
public class XacNhanEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PhatTuId")
    private PhatTu phatTu;

    @Column(name = "ThoiGianHetHan")
    private LocalDate thoiGianHetHan;

    @Column(name = "MaXacNhan")
    private String maXacNhan;

    @Column(name = "DaXacNhan")
    private Boolean daXacNhan;

}
