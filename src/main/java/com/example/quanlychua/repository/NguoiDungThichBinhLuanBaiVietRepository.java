package com.example.quanlychua.repository;

import com.example.quanlychua.entity.NguoiDungThichBinhLuanBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungThichBinhLuanBaiVietRepository extends JpaRepository<NguoiDungThichBinhLuanBaiViet, Integer> {
}
