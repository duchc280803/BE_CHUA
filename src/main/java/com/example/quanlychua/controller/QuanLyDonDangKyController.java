package com.example.quanlychua.controller;

import com.example.quanlychua.response.DonDangKyResponse;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.impl.DonDangKyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/don-dang-ky/")
public class QuanLyDonDangKyController {

    @Autowired
    private DonDangKyServiceImpl donDangKyService;

    @PutMapping("update/{donDangKy}")
    public ResponseEntity<MessageResponse> xuLyDonDangKy(@PathVariable("donDangKy") Integer donDangKy, Principal principal) {
        return new ResponseEntity<>(donDangKyService.xuLyDonDangKy(donDangKy, principal.getName()), HttpStatus.CREATED);
    }

    @GetMapping("show")
    public ResponseEntity<List<DonDangKyResponse>> getList(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return new ResponseEntity<>(donDangKyService.getList(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<List<DonDangKyResponse>> findByDonDangKy(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(donDangKyService.findByDonDangKy(name), HttpStatus.OK);
    }
}