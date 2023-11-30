package com.example.quanlychua.mapper;

import com.example.quanlychua.entity.LoaiBaiViet;
import com.example.quanlychua.request.LoaiBaiVietRequest;

public class LoaiBaiVietMapper {

    public static LoaiBaiViet loaiBaiVietToRequest(LoaiBaiVietRequest loaiBaiVietRequest) {
        LoaiBaiViet loaiBaiViet = new LoaiBaiViet();
        loaiBaiViet.setTenLoai(loaiBaiVietRequest.getTenLoai());
        return loaiBaiViet;
    }

    public static LoaiBaiVietRequest loaiBaiVietRequestToEntity(LoaiBaiViet loaiBaiViet) {
        LoaiBaiVietRequest loaiBaiVietRequest = new LoaiBaiVietRequest();
        loaiBaiVietRequest.setTenLoai(loaiBaiViet.getTenLoai());
        return loaiBaiVietRequest;
    }
}
