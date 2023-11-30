package com.example.quanlychua.repository;

import com.example.quanlychua.entity.PhatTuDaoTrang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhatTuDaoTrangRepository extends JpaRepository<PhatTuDaoTrang, Integer> {
}
