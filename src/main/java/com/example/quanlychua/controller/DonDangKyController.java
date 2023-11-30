package com.example.quanlychua.controller;

import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.impl.DonDangKyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/user/don-dang-ky/")
public class DonDangKyController {

    @Autowired
    private DonDangKyServiceImpl donDangKyService;

    @PostMapping("create/{idDaoTrang}")
    public ResponseEntity<MessageResponse> taoDonDangKy(@PathVariable("idDaoTrang") Integer idDaoTrang, Principal principal) {
        return new ResponseEntity<>(donDangKyService.taoDonDangKy(idDaoTrang, principal.getName()), HttpStatus.CREATED);
    }
}
