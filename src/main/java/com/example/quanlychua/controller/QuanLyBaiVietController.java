package com.example.quanlychua.controller;

import com.example.quanlychua.request.BaiVietRequest;
import com.example.quanlychua.response.BaiVietDetailResponse;
import com.example.quanlychua.response.BaiVietResponse;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.impl.BaiVietServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bai-viet/")
public class QuanLyBaiVietController {

    @Autowired
    private BaiVietServiceImpl baiVietService;

    @GetMapping("detail")
    public ResponseEntity<List<BaiVietDetailResponse>> listDetailBaiViet(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return new ResponseEntity<>(baiVietService.listDetailBaiViet(pageNumber, pageSize), HttpStatus.OK);
    }

    @PutMapping("delete/{id}")
    public ResponseEntity<MessageResponse> xoaBaiViet(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(
                baiVietService.updateBaiViet(id),
                HttpStatus.CREATED);
    }

    @GetMapping("search/{name}")
    public ResponseEntity<List<BaiVietDetailResponse>> search(@PathVariable("name") String name) {
        return new ResponseEntity<>(baiVietService.search(name), HttpStatus.OK);
    }

}
