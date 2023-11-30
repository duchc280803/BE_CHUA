package com.example.quanlychua.controller;

import com.example.quanlychua.request.PhatTuRequest;
import com.example.quanlychua.response.MessageResponse;
import com.example.quanlychua.response.PhatTuResponse;
import com.example.quanlychua.service.impl.PhatTuServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/phat-tu/")
public class QuanLyPhatTuController {

    @Autowired
    private PhatTuServiceImpl phatTuService;

    @GetMapping("all/{name}")
    public ResponseEntity<PhatTuResponse> getAll(@PathVariable("name") String name) {
        return new ResponseEntity<>(phatTuService.getList(name), HttpStatus.OK);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<PhatTuResponse> getDetail(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(phatTuService.getDetail(id), HttpStatus.OK);
    }

    @GetMapping("show-nhan-vien")
    public ResponseEntity<List<PhatTuResponse>> getListNhanVien(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return new ResponseEntity<>(phatTuService.getPageNhanVien(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("show-khach-hang")
    public ResponseEntity<List<PhatTuResponse>> getListKhachHang(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return new ResponseEntity<>(phatTuService.getPageKhachHang(pageNumber, pageSize), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<MessageResponse> themPhatTu(@Valid @RequestBody PhatTuRequest phatTuRequest) {
        return new ResponseEntity<>(phatTuService.themPhatTu(phatTuRequest), HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<MessageResponse> updatePhatTu(@RequestBody PhatTuRequest phatTuRequest, @PathVariable("id") Integer id) {
        return new ResponseEntity<>(phatTuService.updatePhatTu(phatTuRequest, id), HttpStatus.OK);
    }

    @GetMapping("search-employee")
    public ResponseEntity<List<PhatTuResponse> > searchNhanVien(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(phatTuService.searchNhanVien(name), HttpStatus.OK);
    }

    @GetMapping("search-customer")
    public ResponseEntity<List<PhatTuResponse> > searchKhachHang(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(phatTuService.searchKhachHang(name), HttpStatus.OK);
    }

}
