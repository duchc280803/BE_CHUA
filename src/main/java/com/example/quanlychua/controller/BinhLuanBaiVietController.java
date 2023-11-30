package com.example.quanlychua.controller;

import com.example.quanlychua.request.BinhLuanBaiVietRequest;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.impl.BinhLuanBaiVietServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/binh-luan/")
public class BinhLuanBaiVietController {

    @Autowired
    private BinhLuanBaiVietServiceImpl binhLuanBaiVietService;

    @PostMapping("create/{idBaiViet}")
    public ResponseEntity<MessageResponse> themBinhLuanMoi(
            @PathVariable("idBaiViet") Integer idBaiViet,
            @RequestBody BinhLuanBaiVietRequest binhLuanBaiVietRequest,
            Principal principal
    ) {
        return new ResponseEntity<>(binhLuanBaiVietService.vietBinhLuan(
                binhLuanBaiVietRequest,
                principal.getName(),
                idBaiViet),
                HttpStatus.CREATED);
    }

    @PutMapping("sua-binh-luan/{binhLuan}")
    public ResponseEntity<MessageResponse> suaBinhLuan(
            @RequestBody BinhLuanBaiVietRequest binhLuanBaiVietRequest,
            @PathVariable("binhLuan") Integer binhLuan,
            Principal principal
    ) {
        return new ResponseEntity<>(binhLuanBaiVietService.suaBinhLuan(
                binhLuanBaiVietRequest,
                principal.getName(),
                binhLuan),
                HttpStatus.NO_CONTENT);
    }

    @PutMapping("xoa-binh-luan/{binhLuan}")
    public ResponseEntity<MessageResponse> xoaBinhLuan(
            @PathVariable("binhLuan") Integer binhLuan,
            Principal principal
    ) {
        return new ResponseEntity<>(binhLuanBaiVietService.xoaBinhLuan(principal.getName(), binhLuan), HttpStatus.OK);
    }
}
