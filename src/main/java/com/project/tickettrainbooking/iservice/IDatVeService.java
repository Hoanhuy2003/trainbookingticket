package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.DatVeDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.models.DatVe;

import java.util.List;

public interface IDatVeService {
    DatVe createDatVe(DatVeDTO datVeDTO) throws DataNotFoundException;
    DatVe getDatVebyId(int id) throws DataNotFoundException;
    List<DatVe> getAll();
    DatVe updateDatVe(int id, DatVeDTO datVeDTO) throws  DataNotFoundException;
    void deleteDatVe(int id) throws DataNotFoundException;
}
