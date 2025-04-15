package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.ChuyenTauDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.models.ChuyenTau;

import java.util.List;

public interface IChuyenTauService {
    ChuyenTau createChuyenTau(ChuyenTauDTO chuyenTauDTO) throws DataNotFoundException;
    ChuyenTau getChuyenTauById(int id) throws DataNotFoundException;
    List<ChuyenTau> getAllChuyenTau();
    ChuyenTau updateChuyenTau(int id, ChuyenTauDTO chuyenTauDTO) throws DataNotFoundException;
    void deleteChuyenTau(int id) throws DataNotFoundException;
}
