package com.example.quanlychua.entity;

import com.example.quanlychua.enums.QuyenHanEnums;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "quyenhan")
public class QuyenHan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "TenQuyenHan")
    @Enumerated(EnumType.STRING)
    private QuyenHanEnums quyenHanEnums;

    @OneToMany(mappedBy = "quyenHan", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PhatTu> phatTuList;
}
