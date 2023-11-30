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
@Table(name = "loaibaiviet")
public class LoaiBaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "TenLoai")
    private String tenLoai;

    @OneToMany(mappedBy = "loaiBaiViet", fetch = FetchType.LAZY)
    private List<BaiViet> baiVietList;
}
