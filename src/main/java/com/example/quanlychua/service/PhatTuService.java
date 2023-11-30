package com.example.quanlychua.service;

import com.example.quanlychua.request.PhatTuDaoTrangRequest;
import com.example.quanlychua.request.PhatTuRequest;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.response.PhatTuResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhatTuService {

    MessageResponse phatTuThamGiaDaoTrang(Integer daoTrang, String name);

    MessageResponse phatTuKhongThamGiaDaoTrang(Integer daoTrang, String name, PhatTuDaoTrangRequest phatTuDaoTrangRequest);

    PhatTuResponse getList(String name);

    List<PhatTuResponse> getPageNhanVien(Integer pageNumber, Integer pageSize);

    List<PhatTuResponse> getPageKhachHang(Integer pageNumber, Integer pageSize);

    MessageResponse themPhatTu(PhatTuRequest phatTuRequest);

    MessageResponse updatePhatTu(PhatTuRequest phatTuRequest, Integer id);

    PhatTuResponse getDetail(Integer id);

    List<PhatTuResponse>  searchNhanVien(String name);

    List<PhatTuResponse>  searchKhachHang(String name);

}
