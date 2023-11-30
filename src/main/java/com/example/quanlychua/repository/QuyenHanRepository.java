package com.example.quanlychua.repository;

import com.example.quanlychua.entity.QuyenHan;
import com.example.quanlychua.enums.QuyenHanEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyenHanRepository extends JpaRepository<QuyenHan, Integer> {

    QuyenHan findByQuyenHanEnums(QuyenHanEnums quyenHanEnums);

}
