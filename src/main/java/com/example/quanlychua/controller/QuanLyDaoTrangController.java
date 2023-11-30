package com.example.quanlychua.controller;

import com.example.quanlychua.request.DaoTrangRequest;
import com.example.quanlychua.response.DaoTrangDetailResponse;
import com.example.quanlychua.response.DaoTrangResponse;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.impl.DaoTrangServiceImpl;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dao-trang/")
public class QuanLyDaoTrangController {

    @Autowired
    private DaoTrangServiceImpl daoTrangService;

    @PostMapping("create")
    public ResponseEntity<MessageResponse> createDaoTrang(@Valid @RequestBody DaoTrangRequest daoTrangRequest) {
        return new ResponseEntity<>(daoTrangService.createDaoTrang(daoTrangRequest), HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<MessageResponse> updateDaoTrang(
            @Valid
            @RequestBody DaoTrangRequest daoTrangRequest,
            @PathVariable("id") Integer id) {
        return new ResponseEntity<>(daoTrangService.updateDaoTrang(daoTrangRequest, id), HttpStatus.OK);
    }

    @GetMapping("show")
    public ResponseEntity<List<DaoTrangResponse>> getList(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return new ResponseEntity<>(daoTrangService.getList(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<List<DaoTrangResponse>> search(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(daoTrangService.search(name), HttpStatus.OK);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<DaoTrangDetailResponse> getDaoTrang(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(daoTrangService.findByDaoTrang(id), HttpStatus.OK);
    }
}
