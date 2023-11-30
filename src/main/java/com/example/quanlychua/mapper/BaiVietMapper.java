package com.example.quanlychua.mapper;

import com.example.quanlychua.entity.BaiViet;
import com.example.quanlychua.request.BaiVietRequest;

import java.time.LocalDate;

public class BaiVietMapper {

    public static BaiViet baiVietToDTO(BaiVietRequest baiVietRequest) {
        BaiViet baiViet = new BaiViet();
        baiViet.setTieuDe(baiVietRequest.getTieuDeBaiViet());
        baiViet.setThoiGianDang(LocalDate.now());
        baiViet.setNoiDung(baiVietRequest.getNoiDung());
        baiViet.setMoTa(baiVietRequest.getMota());
        return baiViet;
    }
}
