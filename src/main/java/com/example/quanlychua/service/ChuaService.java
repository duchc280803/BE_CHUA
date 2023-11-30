package com.example.quanlychua.service;

import com.example.quanlychua.request.ChuaRequest;
import com.example.quanlychua.response.ChuaResponse;
import com.example.quanlychua.response.MessageResponse;
import org.springframework.data.repository.query.Param;

import java.io.IOException;
import java.util.List;

public interface ChuaService {

    List<ChuaResponse> listChua(Integer pageNumber, Integer pageSize);

    MessageResponse createChua(ChuaRequest chuaRequest) throws IOException;

    MessageResponse updateChua(ChuaRequest chuaRequest, Integer id);

    ChuaResponse findByChua(Integer id);

    List<ChuaResponse> listChua(String name);
}
