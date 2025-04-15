package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.VeTauDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.models.VeTau;

import java.util.List;

public interface IVeTauService {
    VeTau createVeTau(VeTauDTO veTauDTO) throws DataNotFoundException;
    VeTau getVeTauById(int id) throws DataNotFoundException;
    List<VeTau> getAllVeTau();
    VeTau updateVeTau(int id, VeTauDTO veTauDTO) throws DataNotFoundException;
    void deleteVeTau(int id) throws DataNotFoundException;
}
