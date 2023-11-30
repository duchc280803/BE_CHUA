package com.example.quanlychua.controller;

import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.impl.NguoiDungThichBaiVietServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/like-bai/")
public class NguoiDungThichBaiVietController {

    @Autowired
    private NguoiDungThichBaiVietServiceImpl nguoiDungThichBaiVietService;

    @PostMapping("create/{idBaiViet}")
    public ResponseEntity<MessageResponse> likeBai(
            @PathVariable("idBaiViet") Integer idBaiViet,
            Principal principal
    ) {
        return new ResponseEntity<>(nguoiDungThichBaiVietService.likeBaiViet(
                idBaiViet,
                principal.getName()),
                HttpStatus.CREATED);
    }

    @PutMapping("update/{idBaiViet}")
    public ResponseEntity<MessageResponse> dislikeBai(
            @PathVariable("idBaiViet") Integer idBaiViet
    ) {
        return new ResponseEntity<>(nguoiDungThichBaiVietService.dislikeBaiViet(
                idBaiViet),
                HttpStatus.CREATED);
    }
}
