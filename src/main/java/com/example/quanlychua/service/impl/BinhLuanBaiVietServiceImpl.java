package com.example.quanlychua.service.impl;

import com.example.quanlychua.entity.BaiViet;
import com.example.quanlychua.entity.BinhLuanBaiViet;
import com.example.quanlychua.entity.PhatTu;
import com.example.quanlychua.mapper.BinhLuanBaiVietMapper;
import com.example.quanlychua.repository.BaiVietRepository;
import com.example.quanlychua.repository.BinhLuanBaiVietRepository;
import com.example.quanlychua.repository.PhatTuRepository;
import com.example.quanlychua.request.BinhLuanBaiVietRequest;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.BinhLuanBaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BinhLuanBaiVietServiceImpl implements BinhLuanBaiVietService {

    @Autowired
    private BinhLuanBaiVietRepository binhLuanBaiVietRepository;

    @Autowired
    private PhatTuRepository phatTuRepository;

    @Autowired
    private BaiVietRepository baiVietRepository;

    @Override
    public MessageResponse suaBinhLuan(BinhLuanBaiVietRequest binhLuanBaiVietRequest, String phatTu, Integer binhLuan) {
        Optional<BinhLuanBaiViet> findByBinhLuan = binhLuanBaiVietRepository.findById(binhLuan);
        if (findByBinhLuan.isEmpty()) {
            return MessageResponse.builder().message("Bình luận không tồn tại").build();
        }
        findByBinhLuan.get().setBinhLuan(binhLuanBaiVietRequest.getBinhLuan());
        binhLuanBaiVietRepository.save(findByBinhLuan.get());
        return MessageResponse.builder().message("Sửa bình luận thành công").build();
    }

    @Override
    public MessageResponse xoaBinhLuan(String phatTu, Integer binhLuan) {
        Optional<BinhLuanBaiViet> findByBinhLuan = binhLuanBaiVietRepository.findById(binhLuan);
        if (findByBinhLuan.isEmpty()) {
            return MessageResponse.builder().message("Bình luận không tồn tại").build();
        }
        findByBinhLuan.get().setDaXoa(true);
        binhLuanBaiVietRepository.save(findByBinhLuan.get());
        Optional<BaiViet> findByBaiViet = baiVietRepository.findById(findByBinhLuan.get().getBaiViet().getId());
        if (findByBaiViet.isEmpty()) {
            return MessageResponse.builder().message("Bài viết không tồn tại không tồn tại").build();
        }
        findByBaiViet.get().setSoLuotBinhLuan(findByBaiViet.get().getSoLuotBinhLuan() - 1);
        baiVietRepository.save(findByBaiViet.get());
        return MessageResponse.builder().message("Xóa bình luận thành công").build();
    }

    @Override
    public MessageResponse vietBinhLuan(BinhLuanBaiVietRequest binhLuanBaiVietRequest, String phatTu, Integer baiVietId) {
        Optional<PhatTu> findByPhatTu = phatTuRepository.findByTenTaiKhoan(phatTu);
        if (findByPhatTu.isEmpty()) {
            return MessageResponse.builder().message("Người dùng không tồn tại").build();
        }
        Optional<BaiViet> findByBaiViet = baiVietRepository.findById(baiVietId);
        if (findByBaiViet.isEmpty()) {
            return MessageResponse.builder().message("Bài viết không tồn tại không tồn tại").build();
        }
        BinhLuanBaiViet binhLuanBaiViet = BinhLuanBaiVietMapper.binhLuanBaiVietToDTO(binhLuanBaiVietRequest);
        binhLuanBaiViet.setBaiViet(findByBaiViet.get());
        binhLuanBaiViet.setPhatTu(findByPhatTu.get());
        binhLuanBaiViet.setThoiGianTao(LocalDate.now());
        binhLuanBaiViet.setDaXoa(false);
        binhLuanBaiVietRepository.save(binhLuanBaiViet);
        findByBaiViet.get().setSoLuotBinhLuan(findByBaiViet.get().getSoLuotBinhLuan() + 1);
        baiVietRepository.save(findByBaiViet.get());
        return MessageResponse.builder().message("Thêm bình luận mới thành công").build();
    }
}
