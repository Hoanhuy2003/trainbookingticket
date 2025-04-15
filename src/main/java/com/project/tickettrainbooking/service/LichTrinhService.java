package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.ILichTrinhService;
import com.project.tickettrainbooking.models.LichTrinh;
import com.project.tickettrainbooking.pkfk.LichTrinhId;
import com.project.tickettrainbooking.repositorys.GaTauRepository;
import com.project.tickettrainbooking.repositorys.LichTrinhRepository;
import com.project.tickettrainbooking.responses.LichTrinhResponse;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class LichTrinhService implements ILichTrinhService {
    private final LichTrinhRepository lichTrinhRepository;
    private final GaTauRepository gaTauRepository;

    public LichTrinhService(LichTrinhRepository lichTrinhRepository, GaTauRepository gaTauRepository) {
        this.lichTrinhRepository = lichTrinhRepository;
        this.gaTauRepository = gaTauRepository;
    }


    @Override
    public List<LichTrinhResponse> getAll() {

        return lichTrinhRepository.findAll().stream()
                .map(LichTrinhResponse::fromLichTrinh)
                .collect(Collectors.toList());
    }

    @Override
    public LichTrinhResponse updateSchedule(Integer maGaDi, Integer maGaDen, String gioDi, String gioDen) {
        LichTrinhId lichTrinh = new LichTrinhId(maGaDi, maGaDen);
        Optional<LichTrinh> optional = lichTrinhRepository.findById(lichTrinh);
        if (optional.isPresent()) {
            LichTrinh lt = optional.get();
            lt.setGioDi(gioDi);
            lt.setGioDen(gioDen);
            lt.setSoGioDi(TinhSoGio(gioDi, gioDen));
            lichTrinhRepository.save(lt);
            return LichTrinhResponse.fromLichTrinh(lt);
        }
        throw new RuntimeException("Không tìm thấy lịch trình");
    }
    private int TinhSoGio(String gioDi, String gioDen) {
        LocalTime start = LocalTime.parse(gioDi);
        LocalTime end = LocalTime.parse(gioDen);
        return (int) Duration.between(start, end).toHours();
    }
}
