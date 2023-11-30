package com.example.quanlychua.repository;

import com.example.quanlychua.entity.NguoiDungThichBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungThichBaiVietRepository extends JpaRepository<NguoiDungThichBaiViet, Integer> {
}
