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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chua")
public class Chua {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "TenChua")
    private String tenChua;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "NgayThanhLap")
    private LocalDate ngayThanhLap;

    @Column(name = "NguoiTruTri")
    private String nguoiTruTri;

    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image;

    @OneToMany(mappedBy = "chua", fetch = FetchType.LAZY)
    private List<PhatTu> phatTuList;
}
