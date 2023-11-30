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
@Table(name = "nguoidungthichbaiviet")
public class NguoiDungThichBaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PhatTuId")
    private PhatTu phatTu;

    @ManyToOne
    @JoinColumn(name = "BaiVietId")
    private BaiViet baiViet;

    @Column(name = "ThoiGianThich")
    private LocalDate thoiGianThich;

    @Column(name = "DaXoa")
    private Boolean daXoa;


}
