package com.example.quanlychua.repository;

import com.example.quanlychua.entity.TrangThaiBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrangThaiBaiVietRepository extends JpaRepository<TrangThaiBaiViet, Integer> {

    TrangThaiBaiViet findByTenTrangThai(String trangThai);
}
