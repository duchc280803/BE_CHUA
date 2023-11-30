package com.example.quanlychua.repository;

import com.example.quanlychua.entity.PhatTu;
import com.example.quanlychua.response.PhatTuResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhatTuRepository extends JpaRepository<PhatTu, Integer> {

    Optional<PhatTu> findByTenTaiKhoan(String name);

    @Query("SELECT new com.example.quanlychua.response.PhatTuResponse(" +
            "pt.id, pt.ngaySinh, pt.tenTaiKhoan, pt.matKhau, pt.gioiTinh, pt.phapDanh, pt.soDienThoai, pt.email, role.quyenHanEnums) " +
            "FROM PhatTu pt JOIN pt.quyenHan role WHERE pt.id = :id")
    PhatTuResponse getDetail(@Param("id") Integer id);

    @Query("SELECT new com.example.quanlychua.response.PhatTuResponse(" +
            "pt.id, pt.ngaySinh, pt.tenTaiKhoan, pt.matKhau, pt.gioiTinh, pt.phapDanh, pt.soDienThoai, pt.email, role.quyenHanEnums) " +
            "FROM PhatTu pt JOIN pt.quyenHan role WHERE pt.tenTaiKhoan = :name")
    PhatTuResponse getList(@Param("name") String name);

    @Query("SELECT new com.example.quanlychua.response.PhatTuResponse(" +
            "pt.id, pt.ngaySinh, pt.tenTaiKhoan, pt.matKhau, pt.gioiTinh, pt.phapDanh, pt.soDienThoai, pt.email, role.quyenHanEnums) " +
            "FROM PhatTu pt JOIN pt.quyenHan role WHERE role.quyenHanEnums <> 'USER'")
    Page<PhatTuResponse> getPageNhanVien(Pageable pageable);

    @Query("SELECT new com.example.quanlychua.response.PhatTuResponse(" +
            "pt.id, pt.ngaySinh, pt.tenTaiKhoan, pt.matKhau, pt.gioiTinh, pt.phapDanh, pt.soDienThoai, pt.email, role.quyenHanEnums) " +
            "FROM PhatTu pt JOIN pt.quyenHan role WHERE role.quyenHanEnums = 'USER'")
    Page<PhatTuResponse> getPageKhachHang(Pageable pageable);

    @Query("SELECT new com.example.quanlychua.response.PhatTuResponse(" +
            "pt.id, pt.ngaySinh, pt.tenTaiKhoan, pt.matKhau, pt.gioiTinh, pt.phapDanh, pt.soDienThoai, pt.email, role.quyenHanEnums) " +
            "FROM PhatTu pt JOIN pt.quyenHan role WHERE role.quyenHanEnums <> 'USER' AND pt.phapDanh = :name")
    List<PhatTuResponse> searchNhanVien(@Param("name") String name);

    @Query("SELECT new com.example.quanlychua.response.PhatTuResponse(" +
            "pt.id, pt.ngaySinh, pt.tenTaiKhoan, pt.matKhau, pt.gioiTinh, pt.phapDanh, pt.soDienThoai, pt.email, role.quyenHanEnums) " +
            "FROM PhatTu pt JOIN pt.quyenHan role WHERE role.quyenHanEnums = 'USER' AND pt.phapDanh = :name ")
    List<PhatTuResponse> searchKhachHang(@Param("name") String name);
}
