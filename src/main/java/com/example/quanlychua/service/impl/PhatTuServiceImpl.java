package com.example.quanlychua.service.impl;

import com.example.quanlychua.entity.DaoTrang;
import com.example.quanlychua.entity.PhatTu;
import com.example.quanlychua.entity.PhatTuDaoTrang;
import com.example.quanlychua.entity.QuyenHan;
import com.example.quanlychua.repository.DaoTrangRepositroy;
import com.example.quanlychua.repository.PhatTuDaoTrangRepository;
import com.example.quanlychua.repository.PhatTuRepository;
import com.example.quanlychua.request.PhatTuDaoTrangRequest;
import com.example.quanlychua.request.PhatTuRequest;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.response.PhatTuResponse;
import com.example.quanlychua.service.PhatTuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhatTuServiceImpl implements PhatTuService {

    @Autowired
    private PhatTuDaoTrangRepository phatTuDaoTrangRepository;

    @Autowired
    private DaoTrangRepositroy daoTrangRepositroy;

    @Autowired
    private PhatTuRepository phatTuRepository;

    @Override
    public MessageResponse phatTuThamGiaDaoTrang(Integer daoTrang, String name) {
        Optional<DaoTrang> findByDaoTrang = daoTrangRepositroy.findById(daoTrang);
        if (findByDaoTrang.isEmpty()) {
            return MessageResponse.builder().message("Đạo tràng không tồn tại").build();
        }
        Optional<PhatTu> findByPhatTu = phatTuRepository.findByTenTaiKhoan(name);
        PhatTuDaoTrang phatTuDaoTrang = new PhatTuDaoTrang();
        phatTuDaoTrang.setDaThamGia(true);
        phatTuDaoTrang.setDaoTrang(findByDaoTrang.get());
        phatTuDaoTrang.setPhatTu(findByPhatTu.get());
        phatTuDaoTrangRepository.save(phatTuDaoTrang);
        return MessageResponse.builder().message("Tham Gia Đạo Tràng").build();
    }

    @Override
    public MessageResponse phatTuKhongThamGiaDaoTrang(Integer daoTrang, String name, PhatTuDaoTrangRequest phatTuDaoTrangRequest) {
        Optional<DaoTrang> findByDaoTrang = daoTrangRepositroy.findById(daoTrang);
        if (findByDaoTrang.isEmpty()) {
            return MessageResponse.builder().message("Đạo tràng không tồn tại").build();
        }
        Optional<PhatTu> findByPhatTu = phatTuRepository.findByTenTaiKhoan(name);
        PhatTuDaoTrang phatTuDaoTrang = new PhatTuDaoTrang();
        phatTuDaoTrang.setLyDoKhongThamGia(phatTuDaoTrangRequest.getLyDo());
        phatTuDaoTrang.setDaThamGia(false);
        phatTuDaoTrang.setDaoTrang(findByDaoTrang.get());
        phatTuDaoTrang.setPhatTu(findByPhatTu.get());
        phatTuDaoTrangRepository.save(phatTuDaoTrang);
        return MessageResponse.builder().message("Từ Chối Tham Gia Đạo Tràng").build();
    }

    @Override
    public PhatTuResponse getList(String name) {
        return phatTuRepository.getList(name);
    }

    @Override
    public List<PhatTuResponse> getPageNhanVien(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<PhatTuResponse> phatTuResponses = phatTuRepository.getPageNhanVien(pageable);
        return phatTuResponses.getContent();
    }

    @Override
    public List<PhatTuResponse> getPageKhachHang(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<PhatTuResponse> phatTuResponses = phatTuRepository.getPageKhachHang(pageable);
        return phatTuResponses.getContent();
    }

    @Override
    public MessageResponse themPhatTu(PhatTuRequest phatTuRequest) {
        PhatTu phatTu = new PhatTu();
        phatTu.setPhapDanh(phatTuRequest.getPhapDanh());
        phatTu.setEmail(phatTuRequest.getEmail());
        phatTu.setNgaySinh(phatTuRequest.getNgaySinh());
        phatTu.setSoDienThoai(phatTuRequest.getSoDienThoai());
        phatTu.setGioiTinh(phatTuRequest.getGioiTinh());
        phatTu.setQuyenHan(QuyenHan.builder().id(2).build());
        phatTuRepository.save(phatTu);
        return MessageResponse.builder().message("Thêm thành công phật tử").build();
    }

    @Override
    public MessageResponse updatePhatTu(PhatTuRequest phatTuRequest, Integer id) {
        PhatTu findByPhatTu = phatTuRepository.findById(id).get();
        findByPhatTu.setPhapDanh(phatTuRequest.getPhapDanh());
        findByPhatTu.setEmail(phatTuRequest.getEmail());
        findByPhatTu.setNgaySinh(phatTuRequest.getNgaySinh());
        findByPhatTu.setSoDienThoai(phatTuRequest.getSoDienThoai());
        findByPhatTu.setGioiTinh(phatTuRequest.getGioiTinh());
        phatTuRepository.save(findByPhatTu);
        return MessageResponse.builder().message("Update thành công phật tử").build();
    }

    @Override
    public PhatTuResponse getDetail(Integer id) {
        return phatTuRepository.getDetail(id);
    }

    @Override
    public List<PhatTuResponse>  searchNhanVien(String name) {
        return phatTuRepository.searchNhanVien(name);
    }

    @Override
    public List<PhatTuResponse>  searchKhachHang(String name) {
        return searchNhanVien(name);
    }
}
