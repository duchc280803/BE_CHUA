package com.example.quanlychua.repository;

import com.example.quanlychua.entity.BaiViet;
import com.example.quanlychua.response.BaiVietDetailResponse;
import com.example.quanlychua.response.BaiVietResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaiVietRepository extends JpaRepository<BaiViet, Integer> {

    @Query("SELECT new com.example.quanlychua.response.BaiVietResponse(" +
            "bv.id, bv.image, bv.tieuDe, bv.moTa, bv.noiDung, bv.soLuotThich, bv.soLuotBinhLuan)" +
            "FROM BaiViet bv " +
            "JOIN bv.binhLuanBaiVietList listBl " +
            "JOIN listBl.nguoiDungThichBinhLuanBaiVietList ngtblbv " +
            "JOIN bv.trangThaiBaiViet tt " +
            "JOIN bv.nguoiDungThichBaiVietList ndtbv " +
            "JOIN bv.loaiBaiViet lbv WHERE listBl.daXoa = false AND ngtblbv.daXoa = false AND ngtblbv.daXoa = false ")
    Page<BaiVietResponse> pageBaiViet(Pageable pageable);

    @Query("SELECT new com.example.quanlychua.response.BaiVietResponse(" +
            "bv.id, bv.image, bv.tieuDe, bv.moTa, bv.noiDung, bv.soLuotThich, bv.soLuotBinhLuan)" +
            " FROM BaiViet bv where bv.loaiBaiViet.id = :id")
    Page<BaiVietResponse> findByBaiViet(Pageable pageable,@Param("id") Integer id);

    @Query("SELECT new com.example.quanlychua.response.BaiVietDetailResponse(" +
            "bv.id, pt.phapDanh ,bv.image,bv.tieuDe, bv.noiDung, bv.soLuotThich, bv.soLuotBinhLuan)" +
            "FROM BaiViet bv JOIN bv.phatTu pt " +
            "JOIN bv.binhLuanBaiVietList listBl " +
            "JOIN listBl.nguoiDungThichBinhLuanBaiVietList ngtblbv " +
            "JOIN bv.trangThaiBaiViet tt " +
            "JOIN bv.nguoiDungThichBaiVietList ndtbv " +
            "JOIN bv.loaiBaiViet lbv WHERE bv.daXoa = false AND listBl.daXoa = false AND ngtblbv.daXoa = false AND ngtblbv.daXoa = false ")
    Page<BaiVietDetailResponse> getDetailBaiViet(Pageable pageable);

    @Query("SELECT new com.example.quanlychua.response.BaiVietDetailResponse(" +
            "bv.id, pt.phapDanh ,bv.image,bv.tieuDe, bv.noiDung, bv.soLuotThich, bv.soLuotBinhLuan)" +
            "FROM BaiViet bv JOIN bv.phatTu pt " +
            "JOIN bv.binhLuanBaiVietList listBl " +
            "JOIN listBl.nguoiDungThichBinhLuanBaiVietList ngtblbv " +
            "JOIN bv.trangThaiBaiViet tt " +
            "JOIN bv.nguoiDungThichBaiVietList ndtbv " +
            "JOIN bv.loaiBaiViet lbv WHERE bv.daXoa = false AND listBl.daXoa = false AND ngtblbv.daXoa = false AND ngtblbv.daXoa = false AND pt.phapDanh = :name")
    List<BaiVietDetailResponse> search(@Param("name") String name);
}
