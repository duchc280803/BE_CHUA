package com.example.quanlychua.controller;


import com.example.quanlychua.request.ChuaRequest;
import com.example.quanlychua.response.ChuaResponse;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.service.impl.ChuaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chua/")
public class QuanLyChuaController {

    @Autowired
    private ChuaServiceImpl chuaService;

    @GetMapping("page-chua")
    public ResponseEntity<List<ChuaResponse>> listBaiViet(
            @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return new ResponseEntity<>(chuaService.listChua(pageNumber, pageSize), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<MessageResponse> createChua(@Valid @RequestBody ChuaRequest chuaRequest) {
        MessageResponse response = chuaService.createChua(chuaRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<MessageResponse> createChua(
            @RequestBody ChuaRequest chuaRequest,
            @PathVariable("id") Integer id){
        return new ResponseEntity<>(chuaService.updateChua(chuaRequest, id), HttpStatus.OK);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<ChuaResponse> listBaiViet(@PathVariable("id") Integer id){
        return new ResponseEntity<>(chuaService.findByChua(id), HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<List<ChuaResponse>> listChua(@RequestParam(name = "name") String name){
        return new ResponseEntity<>(chuaService.listChua(name), HttpStatus.OK);
    }
}
