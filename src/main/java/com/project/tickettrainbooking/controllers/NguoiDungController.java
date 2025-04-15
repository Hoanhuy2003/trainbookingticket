package com.project.tickettrainbooking.controllers;

import com.project.tickettrainbooking.dtos.NguoiDungDTO;
import com.project.tickettrainbooking.iservice.INguoiDungService;
import com.project.tickettrainbooking.models.NguoiDung;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/nguoidung")
public class NguoiDungController {
    private final INguoiDungService nguoiDungService;


    public NguoiDungController(INguoiDungService nguoiDungService) {
        this.nguoiDungService = nguoiDungService;
    }

    @PostMapping("")
    public ResponseEntity<?> createNguoiDung(@Valid @RequestBody NguoiDungDTO nguoiDungDTO){
        NguoiDung newNguoiDung = nguoiDungService.createNguoiDung(nguoiDungDTO);

        return ResponseEntity.ok(newNguoiDung);
    }
}
