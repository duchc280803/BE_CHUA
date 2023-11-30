package com.example.quanlychua.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phattudaotrang")
public class PhatTuDaoTrang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "DaThamGia")
    private Boolean daThamGia;

    @Column(name = "LyDoKhongThamGia")
    private String lyDoKhongThamGia;

    @ManyToOne
    @JoinColumn(name = "DaoTrangId")
    private DaoTrang daoTrang;

    @ManyToOne
    @JoinColumn(name = "PhatTuId")
    private PhatTu phatTu;

}
