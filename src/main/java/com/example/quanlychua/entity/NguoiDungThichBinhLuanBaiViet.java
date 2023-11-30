package com.example.quanlychua.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nguoidungthichbinhluanbaiviet")
public class NguoiDungThichBinhLuanBaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PhatTuId")
    private PhatTu phatTu;

    @ManyToOne
    @JoinColumn(name = "binhLuanBaiVietId")
    private BinhLuanBaiViet binhLuanBaiViet;

    @Column(name = "ThoiGianLike")
    private LocalDate thoiGianLike;

    @Column(name = "DaXoa")
    private Boolean daXoa;

}
