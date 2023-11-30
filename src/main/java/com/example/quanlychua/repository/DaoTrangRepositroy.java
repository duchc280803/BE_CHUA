package com.example.quanlychua.repository;

import com.example.quanlychua.entity.DaoTrang;
import com.example.quanlychua.request.DaoTrangRequest;
import com.example.quanlychua.response.DaoTrangDetailResponse;
import com.example.quanlychua.response.DaoTrangResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DaoTrangRepositroy extends JpaRepository<DaoTrang, Integer> {

    @Query("SELECT new com.example.quanlychua.response.DaoTrangResponse(" +
            "dt.id, dt.thoiGianBatDau, dt.daKetThuc, dt.nguoiTruTri,dt.noiToChuc,dt.soThanhVienThamGiaMax,dt.soThanhVienThamGia) " +
            "FROM DaoTrang dt")
    Page<DaoTrangResponse> getPage(Pageable pageable);

    @Query("SELECT new com.example.quanlychua.response.DaoTrangDetailResponse(dt.id, dt.noiDung, dt.noiToChuc, dt.soThanhVienThamGiaMax, dt.nguoiTruTri, dt.thoiGianBatDau) " +
            "FROM DaoTrang dt WHERE dt.id = :id")
    Optional<DaoTrangDetailResponse> findByDaoTrang(@Param("id") Integer id);

    @Query("SELECT new com.example.quanlychua.response.DaoTrangResponse(dt.id, dt.thoiGianBatDau, dt.daKetThuc, dt.nguoiTruTri,dt.noiToChuc,dt.soThanhVienThamGiaMax,dt.soThanhVienThamGia) " +
            "FROM DaoTrang dt WHERE dt.nguoiTruTri = :name")
    List<DaoTrangResponse> search(@Param("name") String name);
}
