package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.ToaTauDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.models.ToaTau;

import java.util.List;

public interface IToaTauService {
    ToaTau createToaTau(ToaTauDTO toaTauDTO) throws DataNotFoundException;
    ToaTau getToaTauById(int id) throws DataNotFoundException;
    List<ToaTau> getAllToaTau();
    ToaTau updateToaTau(int id, ToaTauDTO toaTauDTO) throws DataNotFoundException;
    void deleteToaTau(int id) throws DataNotFoundException;
}
