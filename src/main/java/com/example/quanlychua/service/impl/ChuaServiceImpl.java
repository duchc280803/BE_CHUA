package com.example.quanlychua.service.impl;

import com.example.quanlychua.entity.Chua;
import com.example.quanlychua.mapper.ChuaMapper;
import com.example.quanlychua.repository.ChuaRepository;
import com.example.quanlychua.request.ChuaRequest;
import com.example.quanlychua.response.ChuaResponse;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.ChuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ChuaServiceImpl implements ChuaService {

    @Autowired
    private ChuaRepository chuaRepository;

    @Override
    public List<ChuaResponse> listChua(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<ChuaResponse> chuaResponsePage = chuaRepository.pageChua(pageable);
        return chuaResponsePage.getContent();
    }

    @Override
    public MessageResponse createChua(ChuaRequest chuaRequest){
        Chua chua = ChuaMapper.chuaToDto(chuaRequest);
        chua.setNgayThanhLap(LocalDate.now());
        chuaRepository.save(chua);
        return MessageResponse.builder().message("Thêm chùa thành công").build();
    }

    @Override
    public MessageResponse updateChua(ChuaRequest chuaRequest, Integer id) {
        Optional<Chua> findByChua = chuaRepository.findById(id);
        findByChua.get().setTenChua(chuaRequest.getTenChua());
        findByChua.get().setDiaChi(chuaRequest.getDiaChi());
        findByChua.get().setNguoiTruTri(chuaRequest.getNguoiTruTri());
        chuaRepository.save(findByChua.get());
        return MessageResponse.builder().message("Update chùa thành công").build();
    }

    @Override
    public ChuaResponse findByChua(Integer id) {
        return chuaRepository.findByChua(id);
    }

    @Override
    public List<ChuaResponse> listChua(String name) {
        return chuaRepository.listChua(name);
    }
}
