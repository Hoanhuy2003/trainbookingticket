package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.ThanhToanDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.models.ThanhToan;

import java.util.List;

public interface IThanhToanService {
    ThanhToan createThanhToan(ThanhToanDTO thanhToanDTO) throws DataNotFoundException;

    ThanhToan confirmThanhToan(int id) throws DataNotFoundException;

    List<ThanhToan> getByUserId(int userId);

    List<ThanhToan> getByTicketId(int ticketId);

    ThanhToan updateThanhToan(int id,ThanhToanDTO thanhToanDTO) throws DataNotFoundException;

    void deleteThanhToan(int id) throws DataNotFoundException;

}
