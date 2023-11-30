package com.example.quanlychua.service.impl;

import com.example.quanlychua.entity.BaiViet;
import com.example.quanlychua.entity.NguoiDungThichBaiViet;
import com.example.quanlychua.entity.NguoiDungThichBinhLuanBaiViet;
import com.example.quanlychua.entity.PhatTu;
import com.example.quanlychua.repository.BaiVietRepository;
import com.example.quanlychua.repository.NguoiDungThichBaiVietRepository;
import com.example.quanlychua.repository.PhatTuRepository;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.NguoiDungThichBaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class NguoiDungThichBaiVietServiceImpl implements NguoiDungThichBaiVietService {

    @Autowired
    private NguoiDungThichBaiVietRepository nguoiDungThichBaiVietRepository;

    @Autowired
    private BaiVietRepository baiVietRepository;

    @Autowired
    private PhatTuRepository phatTuRepository;

    @Override
    public MessageResponse likeBaiViet(Integer idBaiViet, String phatTu) {
        Optional<BaiViet> findByBaiViet = baiVietRepository.findById(idBaiViet);
        if (findByBaiViet.isEmpty()) {
            return new MessageResponse("Bài viết không tồn tại");
        }
        Optional<PhatTu> findByPhatTu = phatTuRepository.findByTenTaiKhoan(phatTu);
        if (findByPhatTu.isEmpty()) {
            return MessageResponse.builder().message("Người dùng không tồn tại").build();
        }
        NguoiDungThichBaiViet nguoiDungThichBaiViet = new NguoiDungThichBaiViet();
        nguoiDungThichBaiViet.setPhatTu(findByPhatTu.get());
        nguoiDungThichBaiViet.setBaiViet(findByBaiViet.get());
        nguoiDungThichBaiViet.setDaXoa(false);
        nguoiDungThichBaiViet.setThoiGianThich(LocalDate.now());
        nguoiDungThichBaiVietRepository.save(nguoiDungThichBaiViet);
        findByBaiViet.get().setSoLuotThich(findByBaiViet.get().getSoLuotThich() + 1);
        baiVietRepository.save(findByBaiViet.get());
        return new MessageResponse("Like bài viết thành công");
    }

    @Override
    public MessageResponse dislikeBaiViet(Integer idLikeBaiViet) {
        Optional<NguoiDungThichBaiViet> nguoiDungThichBaiViet = nguoiDungThichBaiVietRepository.findById(idLikeBaiViet);
        if (nguoiDungThichBaiViet.isEmpty()) {
            return new MessageResponse("Like bài không tồn tại");
        }
        nguoiDungThichBaiViet.get().setDaXoa(true);
        nguoiDungThichBaiVietRepository.save(nguoiDungThichBaiViet.get());
        Optional<BaiViet> findByBaiViet = baiVietRepository.findById(nguoiDungThichBaiViet.get().getId());
        if (findByBaiViet.isEmpty()) {
            return new MessageResponse("Bài viết không tồn tại");
        }
        findByBaiViet.get().setSoLuotThich(findByBaiViet.get().getSoLuotThich() - 1);
        baiVietRepository.save(findByBaiViet.get());
        return new MessageResponse("Dislike thành công");
    }
}
