package com.example.quanlychua.service.impl;

import com.example.quanlychua.entity.DaoTrang;
import com.example.quanlychua.mapper.DaoTrangMapper;
import com.example.quanlychua.repository.DaoTrangRepositroy;
import com.example.quanlychua.request.DaoTrangRequest;
import com.example.quanlychua.response.DaoTrangDetailResponse;
import com.example.quanlychua.response.DaoTrangResponse;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.DaoTrangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DaoTrangServiceImpl implements DaoTrangService {

    @Autowired
    private DaoTrangRepositroy daoTrangRepositroy;

    @Override
    public MessageResponse createDaoTrang(DaoTrangRequest daoTrangRequest) {
        DaoTrang daoTrang = DaoTrangMapper.daoTrangToDTO(daoTrangRequest);
        daoTrang.setDaKetThuc(false);
        daoTrangRepositroy.save(daoTrang);
        return MessageResponse.builder().message("Thêm đạo tràng thành công").build();
    }

    @Override
    public MessageResponse updateDaoTrang(DaoTrangRequest daoTrangRequest, Integer id) {
        DaoTrang findByDaoTrang = daoTrangRepositroy.findById(id).orElse(null);
        findByDaoTrang.setNoiDung(daoTrangRequest.getNoiDung());
        findByDaoTrang.setSoThanhVienThamGiaMax(daoTrangRequest.getSoThanhVienThamGia());
        findByDaoTrang.setNguoiTruTri(daoTrangRequest.getNguoiTruTri());
        findByDaoTrang.setNoiToChuc(daoTrangRequest.getNoiToChuc());
        daoTrangRepositroy.save(findByDaoTrang);
        return MessageResponse.builder().message("Update đạo tràng thành công").build();
    }

    @Override
    public DaoTrangDetailResponse findByDaoTrang(Integer id) {
        return daoTrangRepositroy.findByDaoTrang(id).orElse(null);
    }

    @Override
    public List<DaoTrangResponse> getList(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<DaoTrangResponse> getDaoTrangResponses = daoTrangRepositroy.getPage(pageable);
        return getDaoTrangResponses.getContent();
    }

    @Override
    public List<DaoTrangResponse> search(String name) {
        return daoTrangRepositroy.search(name);
    }

}
