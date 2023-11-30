package com.example.quanlychua.service;

import com.example.quanlychua.entity.BaiViet;
import com.example.quanlychua.entity.LoaiBaiViet;
import com.example.quanlychua.request.BaiVietRequest;
import com.example.quanlychua.request.LoaiBaiVietRequest;
import com.example.quanlychua.response.BaiVietDetailResponse;
import com.example.quanlychua.response.BaiVietResponse;
import com.example.quanlychua.response.MessageResponse;

import java.security.Principal;
import java.util.List;

public interface BaiVietService {

    List<LoaiBaiViet> liLoaiBaiVietRequests();

    List<BaiVietResponse> findAllBaiViet(Integer pageNumber, Integer pageSize);

    List<BaiVietResponse> findByBaiViet(Integer id,Integer pageNumber, Integer pageSize);

    LoaiBaiVietRequest createLoaiBaiViet(LoaiBaiVietRequest loaiBaiVietRequest);

    MessageResponse createBaiViet(BaiVietRequest baiVietRequest, String username);

    List<BaiVietDetailResponse> listDetailBaiViet(Integer pageNumber, Integer pageSize);

    MessageResponse updateBaiViet(Integer id);

    List<BaiVietDetailResponse> search(String name);
}
