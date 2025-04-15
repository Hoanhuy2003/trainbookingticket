package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.NguoiDungDTO;
import com.project.tickettrainbooking.iservice.INguoiDungService;
import com.project.tickettrainbooking.models.NguoiDung;
import com.project.tickettrainbooking.repositorys.NguoiDungRepository;
import org.springframework.stereotype.Service;

@Service
public class NguoiDungService implements INguoiDungService {
    private final NguoiDungRepository nguoiDungRepository;

    public NguoiDungService(NguoiDungRepository nguoiDungRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
    }

    @Override
    public NguoiDung createNguoiDung(NguoiDungDTO nguoiDungDTO) {
        // kiểm tra sđt
        NguoiDung newNguoiDung = NguoiDung.builder()
                .tenDangNhap(nguoiDungDTO.getTenDangNhap())
                .matKhau(nguoiDungDTO.getMatKhau())
                .role(nguoiDungDTO.getRole())
                .hoTen(nguoiDungDTO.getHoTen())
                .soDienThoai(nguoiDungDTO.getSoDienThoai())
                .email(nguoiDungDTO.getEmail())
                .cccd(nguoiDungDTO.getCccd()).build();
        return nguoiDungRepository.save(newNguoiDung);
    }

    @Override
    public String login(String tenDangNhap, String maKhau) {
        return "";
    }
}
