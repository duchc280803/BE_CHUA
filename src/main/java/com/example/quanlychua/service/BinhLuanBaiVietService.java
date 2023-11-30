package com.example.quanlychua.service;

import com.example.quanlychua.request.BinhLuanBaiVietRequest;
import com.example.quanlychua.response.MessageResponse;

public interface BinhLuanBaiVietService {

    MessageResponse suaBinhLuan(BinhLuanBaiVietRequest binhLuanBaiVietRequest, String phatTu, Integer binhLuan);

    MessageResponse xoaBinhLuan(String phatTu, Integer binhLuan);

    MessageResponse vietBinhLuan(BinhLuanBaiVietRequest binhLuanBaiVietRequest, String phatTu, Integer baiVietId);
}
