package com.example.quanlychua.service;

import com.example.quanlychua.entity.DaoTrang;
import com.example.quanlychua.request.DaoTrangRequest;
import com.example.quanlychua.response.DaoTrangDetailResponse;
import com.example.quanlychua.response.DaoTrangResponse;
import com.example.quanlychua.response.MessageResponse;

import java.util.List;

public interface DaoTrangService {

    MessageResponse createDaoTrang(DaoTrangRequest daoTrangRequest);

    MessageResponse updateDaoTrang(DaoTrangRequest daoTrangRequest, Integer id);

    DaoTrangDetailResponse findByDaoTrang(Integer id);

    List<DaoTrangResponse> getList(Integer pageNumber, Integer pageSize);

    List<DaoTrangResponse> search(String name);
}
