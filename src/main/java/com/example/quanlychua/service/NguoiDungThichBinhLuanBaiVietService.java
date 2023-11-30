package com.example.quanlychua.service;

import com.example.quanlychua.response.MessageResponse;

public interface NguoiDungThichBinhLuanBaiVietService {

    MessageResponse thichBinhLuan(Integer idBinhLuan, String phatTu);

    MessageResponse dislikeBinhLuan(Integer idLikeBinhLuan);
}
