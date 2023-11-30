package com.example.quanlychua.service.impl;

import com.example.quanlychua.entity.BaiViet;
import com.example.quanlychua.entity.LoaiBaiViet;
import com.example.quanlychua.entity.PhatTu;
import com.example.quanlychua.entity.TrangThaiBaiViet;
import com.example.quanlychua.mapper.BaiVietMapper;
import com.example.quanlychua.mapper.LoaiBaiVietMapper;
import com.example.quanlychua.repository.BaiVietRepository;
import com.example.quanlychua.repository.LoaiBaiVietRepository;
import com.example.quanlychua.repository.PhatTuRepository;
import com.example.quanlychua.repository.TrangThaiBaiVietRepository;
import com.example.quanlychua.request.BaiVietRequest;
import com.example.quanlychua.request.LoaiBaiVietRequest;
import com.example.quanlychua.response.BaiVietDetailResponse;
import com.example.quanlychua.response.BaiVietResponse;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.BaiVietService;
import com.example.quanlychua.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BaiVietServiceImpl implements BaiVietService {

    @Autowired
    private LoaiBaiVietRepository loaiBaiVietRepository;

    @Autowired
    private BaiVietRepository baiVietRepository;

    @Autowired
    private TrangThaiBaiVietRepository trangThaiBaiVietRepository;

    @Autowired
    private PhatTuRepository phatTuRepository;

    @Override
    public List<LoaiBaiViet> liLoaiBaiVietRequests() {
        return loaiBaiVietRepository.findAll();
    }

    @Override
    public List<BaiVietResponse> findAllBaiViet(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<BaiVietResponse> baiVietResponsePage = baiVietRepository.pageBaiViet(pageable);
        return baiVietResponsePage.getContent();
    }

    @Override
    public List<BaiVietResponse> findByBaiViet(Integer id, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<BaiVietResponse> baiVietResponsePage = baiVietRepository.findByBaiViet(pageable, id);
        return baiVietResponsePage.getContent();
    }

    @Override
    public LoaiBaiVietRequest createLoaiBaiViet(LoaiBaiVietRequest loaiBaiVietRequest) {
        LoaiBaiViet loaiBaiViet = LoaiBaiVietMapper.loaiBaiVietToRequest(loaiBaiVietRequest);
        LoaiBaiViet loaiBaiVietSave = loaiBaiVietRepository.save(loaiBaiViet);
        return LoaiBaiVietMapper.loaiBaiVietRequestToEntity(loaiBaiVietSave);
    }

    @Override
    public MessageResponse createBaiViet(BaiVietRequest baiVietRequest, String username) {
        PhatTu phatTu = phatTuRepository.findByTenTaiKhoan(username).orElse(null);
        if (phatTu == null) {
            return MessageResponse.builder().message("Thông tig không tồn n người dùntại").build();
        }
        Optional<LoaiBaiViet> findByIdLoaiBaiViet = loaiBaiVietRepository.findByTenLoai(baiVietRequest.getLoaiBaiViet());


        if (findByIdLoaiBaiViet.isEmpty()) {
            return new MessageResponse("Loại bài viết không tồn tại");
        }
        TrangThaiBaiViet trangThaiBaiViet = trangThaiBaiVietRepository.findByTenTrangThai("Đang Hiển Thị");
        BaiViet baiViet = BaiVietMapper.baiVietToDTO(baiVietRequest);
        baiViet.setLoaiBaiViet(findByIdLoaiBaiViet.get());
        baiViet.setTrangThaiBaiViet(trangThaiBaiViet);
        baiViet.setPhatTu(phatTu); // Gán thông tin người dùng vào bài viết
        baiVietRepository.save(baiViet);
        return MessageResponse.builder().
                message("Thêm bài viết mới thành công").
                build();
    }

    @Override
    public List<BaiVietDetailResponse> listDetailBaiViet(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<BaiVietDetailResponse> baiVietResponsePage = baiVietRepository.getDetailBaiViet(pageable);
        return baiVietResponsePage.getContent();
    }

    @Override
    public MessageResponse updateBaiViet(Integer id) {
        BaiViet baiViet = baiVietRepository.findById(id).orElse(null);
        baiViet.setDaXoa(true);
        baiVietRepository.save(baiViet);
        return MessageResponse.builder().
                message("Xóa Thành Công Bài Viết").
                build();
    }

    @Override
    public List<BaiVietDetailResponse> search(String name) {
        return baiVietRepository.search(name);
    }

}
