package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.LoaiKhachDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.models.LoaiKhach;

import java.util.List;

public interface ILoaiKhachService {
    LoaiKhach createLoaiKhach(LoaiKhachDTO loaiKhachDTO);
    LoaiKhach getLoaiKhachById(int id) throws DataNotFoundException;
    List<LoaiKhach> getAllLoaiKhach();
    LoaiKhach updateLoaiKhach(int id, LoaiKhachDTO loaiKhachDTO) throws DataNotFoundException;
    void deleteLoaiKhach(int id) throws DataNotFoundException;
}
