package com.example.quanlychua.controller;

import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.impl.NguoiDungThichBinhLuanBaiVietServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/like-binh-luan/")
public class NguoiDungThichBinhLuanBaiVietController {

    @Autowired
    private NguoiDungThichBinhLuanBaiVietServiceImpl nguoiDungThichBinhLuanBaiVietService;

    @PostMapping("create/{idBinhLuan}")
    public ResponseEntity<MessageResponse> themBinhLuanMoi(
            @PathVariable("idBinhLuan") Integer idBinhLuan,
            Principal principal
    ) {
        return new ResponseEntity<>(nguoiDungThichBinhLuanBaiVietService.thichBinhLuan(
                idBinhLuan,
                principal.getName()),
                HttpStatus.CREATED);
    }

    @PostMapping("update/{idBinhLuan}")
    public ResponseEntity<MessageResponse> dislikeBinhLuan(
            @PathVariable("idBinhLuan") Integer idBinhLuan
    ) {
        return new ResponseEntity<>(nguoiDungThichBinhLuanBaiVietService.dislikeBinhLuan(idBinhLuan), HttpStatus.CREATED);
    }
}
