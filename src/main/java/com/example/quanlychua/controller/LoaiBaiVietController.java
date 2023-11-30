package com.example.quanlychua.controller;

import com.example.quanlychua.entity.LoaiBaiViet;
import com.example.quanlychua.request.LoaiBaiVietRequest;
import com.example.quanlychua.service.impl.BaiVietServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loai-bai-viet/")
public class LoaiBaiVietController {

    @Autowired
    private BaiVietServiceImpl baiVietService;

    @GetMapping("show")
    public ResponseEntity<List<LoaiBaiViet>> finAll() {
        return new ResponseEntity<>(baiVietService.liLoaiBaiVietRequests(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<LoaiBaiVietRequest> createLoaiBaiViet(@RequestBody LoaiBaiVietRequest loaiBaiVietRequest) {
        return new ResponseEntity<>(baiVietService.createLoaiBaiViet(loaiBaiVietRequest), HttpStatus.CREATED);
    }

}
