package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.GheDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.models.Ghe;

import java.util.List;

public interface IGheService {
    Ghe createGhe(GheDTO gheDTO) throws DataNotFoundException;
    Ghe getGheById(int id) throws DataNotFoundException;
    List<Ghe> getAllGhe();
    Ghe updateGhe(int id, GheDTO gheDTO) throws DataNotFoundException;
    void deleteGhe(int id) throws DataNotFoundException;
}
