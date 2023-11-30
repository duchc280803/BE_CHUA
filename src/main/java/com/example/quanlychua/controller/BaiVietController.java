package com.example.quanlychua.controller;

import com.example.quanlychua.request.BaiVietRequest;
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
@RequestMapping("/api/user/bai-viet/")
public class BaiVietController {

    @Autowired
    private BaiVietServiceImpl baiVietService;

    @GetMapping("page-bai")
    public ResponseEntity<List<BaiVietResponse>> listBaiViet(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return new ResponseEntity<>(baiVietService.findAllBaiViet(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("page-bai/{id}")
    public ResponseEntity<List<BaiVietResponse>> loadBaiVietByLoai(
            @PathVariable("id") Integer id,
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return new ResponseEntity<>(baiVietService.findByBaiViet(id, pageNumber, pageSize), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<MessageResponse> createBaiViet(
            @RequestBody BaiVietRequest baiVietRequest,
            Principal principal
    ) {
        return new ResponseEntity<>(
                baiVietService.createBaiViet(baiVietRequest, principal.getName()),
                HttpStatus.CREATED);
    }

}
