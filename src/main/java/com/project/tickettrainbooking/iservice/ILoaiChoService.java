package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.LoaiChoDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.models.LoaiCho;

import java.util.List;

public interface ILoaiChoService {
    LoaiCho createLoaiCho(LoaiChoDTO loaiChoDTO);
    LoaiCho getLoaiChoById(int id) throws DataNotFoundException;
    List<LoaiCho> getAllLoaiCho();
    LoaiCho update(int id, LoaiChoDTO loaiChoDTO) throws DataNotFoundException;
    void deleteLoaiCho(int id) throws DataNotFoundException;
}
