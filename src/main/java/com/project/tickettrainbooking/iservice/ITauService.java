package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.TauDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.models.Tau;

import java.util.List;

public interface ITauService {
    Tau createTau(TauDTO tauDTO);
    Tau getTauById(int id) throws DataNotFoundException;
    List<Tau> getAllTau();
    Tau updateTau(int id, TauDTO tauDTO) throws DataNotFoundException;
    void deleteTau(int id) throws DataNotFoundException;
}
