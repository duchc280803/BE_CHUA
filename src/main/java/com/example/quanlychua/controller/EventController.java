package com.example.quanlychua.controller;

import com.example.quanlychua.response.DaoTrangResponse;
import com.example.quanlychua.service.impl.DaoTrangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/dao-trang/")
public class EventController {

    @Autowired
    private DaoTrangServiceImpl daoTrangService;

    @GetMapping("show")
    public ResponseEntity<List<DaoTrangResponse>> getList(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "9") Integer pageSize) {
        return new ResponseEntity<>(daoTrangService.getList(pageNumber, pageSize), HttpStatus.OK);
    }
}
