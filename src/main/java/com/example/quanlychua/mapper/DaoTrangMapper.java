package com.example.quanlychua.mapper;

import com.example.quanlychua.entity.DaoTrang;
import com.example.quanlychua.request.DaoTrangRequest;

import java.time.LocalDate;

public class DaoTrangMapper {

    public static DaoTrang daoTrangToDTO(DaoTrangRequest daoTrangRequest) {
        DaoTrang daoTrang = new DaoTrang();
        daoTrang.setNoiDung(daoTrangRequest.getNoiDung());
        daoTrang.setNoiToChuc(daoTrangRequest.getNoiToChuc());
        daoTrang.setNguoiTruTri(daoTrangRequest.getNguoiTruTri());
        daoTrang.setThoiGianBatDau(LocalDate.now());
        daoTrang.setSoThanhVienThamGiaMax(daoTrangRequest.getSoThanhVienThamGia());
        daoTrang.setSoThanhVienThamGia(0);
        return daoTrang;
    }
}
