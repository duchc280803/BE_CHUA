package com.example.quanlychua.repository;

import com.example.quanlychua.entity.DonDangKy;
import com.example.quanlychua.response.DonDangKyResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface DonDangKyRepository extends JpaRepository<DonDangKy, Integer> {

    @Query("SELECT NEW com.example.quanlychua.response.DonDangKyResponse(ddk.id, ddk.ngayGuiDon, ddk.ngayXuLy, pt.phapDanh, tt.tenTrangThai) " +
            "FROM DonDangKy ddk JOIN ddk.phatTu pt JOIN ddk.trangThaiDon tt")
    Page<DonDangKyResponse> getPage(Pageable pageable);

    @Query("SELECT NEW com.example.quanlychua.response.DonDangKyResponse(ddk.id, ddk.ngayGuiDon, ddk.ngayXuLy, pt.phapDanh, tt.tenTrangThai) " +
            "FROM DonDangKy ddk JOIN ddk.phatTu pt JOIN ddk.trangThaiDon tt WHERE pt.phapDanh = :name")
    List<DonDangKyResponse> findByDonDangKy(@Param("name") String name);
}
