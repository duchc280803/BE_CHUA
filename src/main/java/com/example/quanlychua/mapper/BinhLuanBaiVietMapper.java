package com.example.quanlychua.mapper;

import com.example.quanlychua.entity.BinhLuanBaiViet;
import com.example.quanlychua.request.BinhLuanBaiVietRequest;

public class BinhLuanBaiVietMapper {

    public static BinhLuanBaiViet binhLuanBaiVietToDTO(BinhLuanBaiVietRequest binhLuanBaiVietRequest) {
        BinhLuanBaiViet binhLuanBaiViet = new BinhLuanBaiViet();
        binhLuanBaiViet.setBinhLuan(binhLuanBaiVietRequest.getBinhLuan());
        return binhLuanBaiViet;
    }
}
