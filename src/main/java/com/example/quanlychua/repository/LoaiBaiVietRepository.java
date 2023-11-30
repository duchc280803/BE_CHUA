package com.example.quanlychua.repository;

import com.example.quanlychua.entity.LoaiBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoaiBaiVietRepository extends JpaRepository<LoaiBaiViet, Integer> {

    Optional<LoaiBaiViet> findByTenLoai(String name);
}
