package com.example.quanlychua.controller;

import com.example.quanlychua.request.PhatTuDaoTrangRequest;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.impl.PhatTuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/phat-tu-dao-trang/")
public class PhatTuDaoTrangController {

    @Autowired
    private PhatTuServiceImpl phatTuService;

    @PostMapping("tham-gia/{daoTrang}")
    public ResponseEntity<MessageResponse> phatTuThamGiaDaoTrang(@PathVariable("daoTrang") Integer daoTrang, Principal principal) {
        return new ResponseEntity<>(phatTuService.phatTuThamGiaDaoTrang(daoTrang, principal.getName()), HttpStatus.CREATED);
    }

    @PostMapping("khong-tham-gia")
    public ResponseEntity<MessageResponse> phatTuKhongThamGiaDaoTrang(
            @PathVariable("daoTrang") Integer daoTrang,
            Principal principal,
            @RequestBody PhatTuDaoTrangRequest phatTuDaoTrangRequest) {
        return new ResponseEntity<>(phatTuService.phatTuKhongThamGiaDaoTrang(daoTrang, principal.getName(), phatTuDaoTrangRequest), HttpStatus.CREATED);
    }
}
