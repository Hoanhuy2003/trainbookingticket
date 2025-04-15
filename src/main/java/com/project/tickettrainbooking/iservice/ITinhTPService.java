package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.TinhTPDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.models.TinhTP;

import java.util.List;

public interface ITinhTPService {
    List<TinhTP> getAllTinhTP();
    TinhTP creteTinhTP(TinhTPDTO tinhTPDTO);
    TinhTP getTinhTPById(Integer id) throws DataNotFoundException;
    TinhTP updateTinhTP(Integer id, TinhTPDTO tinhTPDTO) throws DataNotFoundException;
    void deleteTinhTP(Integer id) throws DataNotFoundException;
}
