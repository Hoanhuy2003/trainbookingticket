package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.NguoiDungDTO;
import com.project.tickettrainbooking.models.NguoiDung;

public interface INguoiDungService {
    NguoiDung createNguoiDung(NguoiDungDTO nguoiDungDTO);

    String login(String tenDangNhap, String maKhau);

}
