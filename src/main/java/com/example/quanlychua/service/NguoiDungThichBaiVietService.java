package com.example.quanlychua.service;

import com.example.quanlychua.response.MessageResponse;

public interface NguoiDungThichBaiVietService {

    MessageResponse likeBaiViet(Integer idBaiViet, String phatTu);

    MessageResponse dislikeBaiViet(Integer idLikeBaiViet);
}
