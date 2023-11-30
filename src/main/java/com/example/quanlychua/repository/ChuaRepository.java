package com.example.quanlychua.repository;

import com.example.quanlychua.entity.Chua;
import com.example.quanlychua.response.BaiVietResponse;
import com.example.quanlychua.response.ChuaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChuaRepository extends JpaRepository<Chua, Integer> {

    @Query("SELECT new com.example.quanlychua.response.ChuaResponse(c.id, c.tenChua, c.diaChi, c.ngayThanhLap, c.nguoiTruTri) FROM Chua c")
    Page<ChuaResponse> pageChua(Pageable pageable);

    @Query("SELECT new com.example.quanlychua.response.ChuaResponse(c.id, c.tenChua, c.diaChi, c.ngayThanhLap, c.nguoiTruTri) FROM Chua c WHERE c.id = :id")
    ChuaResponse findByChua(@Param("id") Integer id);

    @Query("SELECT new com.example.quanlychua.response.ChuaResponse(c.id, c.tenChua, c.diaChi, c.ngayThanhLap, c.nguoiTruTri)" +
            "FROM Chua c WHERE c.tenChua = :name")
    List<ChuaResponse> listChua(@Param("name") String name);
}
