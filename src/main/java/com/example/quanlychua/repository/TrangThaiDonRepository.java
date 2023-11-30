package com.example.quanlychua.repository;

import com.example.quanlychua.entity.TrangThaiDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrangThaiDonRepository extends JpaRepository<TrangThaiDon, Integer> {
}
