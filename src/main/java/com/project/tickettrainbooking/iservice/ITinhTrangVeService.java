package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.TinhTrangVeDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.models.TinhTrangVe;

import java.util.List;

public interface ITinhTrangVeService {
    TinhTrangVe createTinhTrang(TinhTrangVeDTO tinhTrangVeDTO) throws  DataNotFoundException;
    TinhTrangVe getTinhTrangById(int id) throws DataNotFoundException;
    List<TinhTrangVe> getAll();
    TinhTrangVe update(int id, TinhTrangVeDTO tinhTrangVeDTO) throws DataNotFoundException;
    void delete(int id) throws DataNotFoundException;
}
