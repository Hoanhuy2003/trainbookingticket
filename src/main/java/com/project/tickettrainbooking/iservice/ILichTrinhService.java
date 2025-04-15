package com.project.tickettrainbooking.iservice;

import com.project.tickettrainbooking.pkfk.LichTrinhId;
import com.project.tickettrainbooking.responses.LichTrinhResponse;

import java.util.List;

public interface ILichTrinhService {
    List<LichTrinhResponse> getAll();
    LichTrinhResponse updateSchedule(Integer maGaDi, Integer maGaDen, String gioDi, String gioDen);
}
