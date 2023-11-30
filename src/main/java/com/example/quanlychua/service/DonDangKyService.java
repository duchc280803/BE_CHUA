package com.example.quanlychua.service;

import com.example.quanlychua.response.DonDangKyResponse;
import com.example.quanlychua.response.MessageResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonDangKyService {

    MessageResponse taoDonDangKy(Integer idDaoTrang, String name);

    MessageResponse xuLyDonDangKy(Integer donDangKy, String name);

    List<DonDangKyResponse> getList(Integer pageNumber, Integer pageSize);

    List<DonDangKyResponse> findByDonDangKy(String name);
}
