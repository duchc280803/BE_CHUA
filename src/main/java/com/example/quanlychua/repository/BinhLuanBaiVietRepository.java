package com.example.quanlychua.repository;

import com.example.quanlychua.entity.BinhLuanBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinhLuanBaiVietRepository extends JpaRepository<BinhLuanBaiViet, Integer> {
}
