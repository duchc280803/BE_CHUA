package com.example.quanlychua.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trangthaidon")
public class TrangThaiDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "TenTrangThai")
    private String tenTrangThai;

    @OneToMany(mappedBy = "trangThaiDon", fetch = FetchType.LAZY)
    private List<DonDangKy> donDangKyList;
}
