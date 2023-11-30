package com.example.quanlychua.service.impl;

import com.example.quanlychua.entity.BinhLuanBaiViet;
import com.example.quanlychua.entity.NguoiDungThichBinhLuanBaiViet;
import com.example.quanlychua.repository.BinhLuanBaiVietRepository;
import com.example.quanlychua.repository.NguoiDungThichBinhLuanBaiVietRepository;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.NguoiDungThichBinhLuanBaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class NguoiDungThichBinhLuanBaiVietServiceImpl implements NguoiDungThichBinhLuanBaiVietService {

    @Autowired
    private NguoiDungThichBinhLuanBaiVietRepository nguoiDungThichBinhLuanBaiVietRepository;

    @Autowired
    private BinhLuanBaiVietRepository binhLuanBaiVietRepository;

    @Override
    public MessageResponse thichBinhLuan(Integer idBinhLuan, String phatTu) {
        Optional<BinhLuanBaiViet> binhLuanBaiViet = binhLuanBaiVietRepository.findById(idBinhLuan);
        if (binhLuanBaiViet.isEmpty()) {
            return MessageResponse.builder().message("Không có bình luận").build();
        }
        NguoiDungThichBinhLuanBaiViet nguoiDungThichBinhLuanBaiViet = new NguoiDungThichBinhLuanBaiViet();
        nguoiDungThichBinhLuanBaiViet.setBinhLuanBaiViet(binhLuanBaiViet.get());
        nguoiDungThichBinhLuanBaiViet.setDaXoa(false);
        nguoiDungThichBinhLuanBaiViet.setThoiGianLike(LocalDate.now());
        nguoiDungThichBinhLuanBaiVietRepository.save(nguoiDungThichBinhLuanBaiViet);
        return MessageResponse.builder().message("Like bình luận thành công").build();
    }

    @Override
    public MessageResponse dislikeBinhLuan(Integer idLikeBinhLuan) {
        Optional<NguoiDungThichBinhLuanBaiViet> binhLuanBaiViet = nguoiDungThichBinhLuanBaiVietRepository.findById(idLikeBinhLuan);
        if (binhLuanBaiViet.isEmpty()) {
            return MessageResponse.builder().message("Không có Like nào").build();
        }
        binhLuanBaiViet.get().setDaXoa(true);
        nguoiDungThichBinhLuanBaiVietRepository.save(binhLuanBaiViet.get());
        return null;
    }
}
