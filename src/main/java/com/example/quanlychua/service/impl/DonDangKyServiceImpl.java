package com.example.quanlychua.service.impl;

import com.example.quanlychua.entity.DaoTrang;
import com.example.quanlychua.entity.DonDangKy;
import com.example.quanlychua.entity.PhatTu;
import com.example.quanlychua.entity.TrangThaiDon;
import com.example.quanlychua.repository.DaoTrangRepositroy;
import com.example.quanlychua.repository.DonDangKyRepository;
import com.example.quanlychua.repository.PhatTuRepository;
import com.example.quanlychua.response.DonDangKyResponse;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.DonDangKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DonDangKyServiceImpl implements DonDangKyService {

    @Autowired
    private DonDangKyRepository donDangKyRepository;

    @Autowired
    private PhatTuRepository phatTuRepository;

    @Autowired
    private DaoTrangRepositroy daoTrangRepositroy;

    @Override
    public MessageResponse taoDonDangKy(Integer idDaoTrang, String name) {
        Optional<PhatTu> phatTu = phatTuRepository.findByTenTaiKhoan(name);
        Optional<DaoTrang> daoTrang = daoTrangRepositroy.findById(idDaoTrang);
        if (daoTrang.isEmpty()) {
            return MessageResponse.builder().message("Đạo Tràng Không Tồn Tại").build();
        }
        if (daoTrang.get().getSoThanhVienThamGiaMax() <= daoTrang.get().getSoThanhVienThamGia()) {
            return MessageResponse.builder().message("Số thành viên tham gia đã full").build();
        }
        DonDangKy donDangKy = new DonDangKy();
        donDangKy.setNgayGuiDon(LocalDate.now());
        donDangKy.setTrangThaiDon(TrangThaiDon.builder().id(3).build());
        donDangKy.setPhatTu(phatTu.get());
        donDangKy.setDaoTrang(daoTrang.get());
        donDangKyRepository.save(donDangKy);
        daoTrang.get().setSoThanhVienThamGia(daoTrang.get().getSoThanhVienThamGia() + 1);
        daoTrangRepositroy.save(daoTrang.get());
        return MessageResponse.builder().message("Gửi Đơn Đăng Ký Thành Công").build();
    }

    @Override
    public MessageResponse xuLyDonDangKy(Integer donDangKy, String name) {
        Optional<DonDangKy> findByDonDangKy = donDangKyRepository.findById(donDangKy);
        if (findByDonDangKy.isEmpty()) {
            return MessageResponse.builder().message("Đơn Đăng Ký Không Tồn Tại").build();
        }
        findByDonDangKy.get().setTrangThaiDon(TrangThaiDon.builder().id(1).build());
        findByDonDangKy.get().setNgayXuLy(LocalDate.now());
        donDangKyRepository.save(findByDonDangKy.get());
        return MessageResponse.builder().message("Duyệt đơn thành công").build();
    }

    @Override
    public List<DonDangKyResponse> getList(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<DonDangKyResponse> getPage = donDangKyRepository.getPage(pageable);
        return getPage.getContent();
    }

    @Override
    public List<DonDangKyResponse> findByDonDangKy(String name) {
        return donDangKyRepository.findByDonDangKy(name);
    }

}
