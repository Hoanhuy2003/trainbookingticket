package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.GaTauDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.models.GaTau;

import java.util.List;

public interface IGaTauService {
    GaTau createGaTau(GaTauDTO gaTauDTO) throws DataNotFoundException;
    GaTau getGaTauById(Integer id) throws DataNotFoundException;
    List<GaTau> getAllGaTau();
    GaTau updateGaTau(Integer id, GaTauDTO gaTauDTO) throws DataNotFoundException;
    void deleteGaTau(Integer id) throws DataNotFoundException;
}
