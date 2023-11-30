package com.example.quanlychua.mapper;

import com.example.quanlychua.entity.Chua;
import com.example.quanlychua.request.ChuaRequest;

import java.io.IOException;

public class ChuaMapper {

    public static Chua chuaToDto(ChuaRequest chuaRequest) {
        Chua chua = new Chua();
        chua.setTenChua(chuaRequest.getTenChua());
        chua.setDiaChi(chuaRequest.getDiaChi());
        chua.setNguoiTruTri(chuaRequest.getNguoiTruTri());
        return chua;
    }
}
