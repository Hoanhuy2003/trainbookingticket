package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.dtos.GaDungDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.models.GaDung;
import com.project.tickettrainbooking.pkfk.GaDungId;
import com.project.tickettrainbooking.responses.GaDungResponse;

import java.util.List;

public interface IGaDungService {
    List<GaDungResponse> getByChuyenTau(Integer maGaDi, Integer maGaDen, Integer maTau);
    GaDung create(GaDungDTO gaDungDTO) throws DataNotFoundException;
    GaDungResponse update(GaDungId id, GaDungDTO gaDungDTO);
    void delete(GaDungId id);

}
