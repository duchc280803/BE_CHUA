package com.example.quanlychua.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trangthaibaiviet")
public class TrangThaiBaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "TenTrangThai")
    private String tenTrangThai;

    @OneToMany(mappedBy = "trangThaiBaiViet", fetch = FetchType.LAZY)
    private List<BaiViet> listBaiViet;
}
