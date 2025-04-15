package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.BangGiaDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.models.BangGia;

import java.util.List;

public interface IBangGiaService {
    BangGia createBangGia(BangGiaDTO bangGiaDTO) throws DataNotFoundException;
    BangGia getBangGiaById(int id) throws DataNotFoundException;
    List<BangGia> getAllBangGia();
    BangGia updateBangGia(int id, BangGiaDTO bangGiaDTO) throws  DataNotFoundException;
    void deleteBangGia(int id) throws DataNotFoundException;


}
