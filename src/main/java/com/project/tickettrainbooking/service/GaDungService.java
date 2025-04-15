package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.GaDungDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IGaDungService;
import com.project.tickettrainbooking.models.GaDung;
import com.project.tickettrainbooking.models.GaTau;
import com.project.tickettrainbooking.models.Tau;
import com.project.tickettrainbooking.pkfk.GaDungId;
import com.project.tickettrainbooking.repositorys.GaDungRepository;
import com.project.tickettrainbooking.repositorys.GaTauRepository;
import com.project.tickettrainbooking.repositorys.TauRepository;
import com.project.tickettrainbooking.responses.GaDungResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GaDungService implements IGaDungService {
    private final GaDungRepository gaDungRepository;
    private final GaTauRepository gaTauRepository;
    private final TauRepository tauRepository;

    @Override
    public List<GaDungResponse> getByChuyenTau(Integer maGaDi, Integer maGaDen, Integer maTau) {
        return gaDungRepository.findByIdMaGaDiAndIdMaGaDenAndIdMaTau(maGaDi, maGaDen, maTau)
                .stream()
                .map(GaDungResponse::fromGaDung)
                .collect(Collectors.toList());
    }

    @Override
    public GaDung create(GaDungDTO gaDungDTO) throws DataNotFoundException {
        // Kiểm tra các ga và tàu
        GaTau gaDen = gaTauRepository.findById(gaDungDTO.getMaGaDen())
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy ga đến với mã " + gaDungDTO.getMaGaDen()));

        GaTau gaDi = gaTauRepository.findById(gaDungDTO.getMaGaDi())
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy ga đi với mã " + gaDungDTO.getMaGaDi()));

        GaTau gaDung = gaTauRepository.findById(gaDungDTO.getMaGaDung())
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy ga dừng với mã " + gaDungDTO.getMaGaDung()));

        Tau tau = tauRepository.findById(gaDungDTO.getMaTau())
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy tàu với mã " + gaDungDTO.getMaTau()));

        // Tạo đối tượng GaDungId nếu bạn dùng composite key
        GaDungId gaDungId = new GaDungId(
                gaDungDTO.getMaGaDen(),
                gaDungDTO.getMaGaDi(),
                gaDungDTO.getMaGaDung(),
                gaDungDTO.getMaTau()
        );

        // Tạo entity
        GaDung entity = GaDung.builder()
                .id(gaDungId)
                .gaDen(gaDen)
                .gaDi(gaDi)
                .gaDung(gaDung)
                .tau(tau)
                .gioBatDauDung(gaDungDTO.getGioBatDauDung())
                .gioKetThucDung(gaDungDTO.getGioKetThucDung())
                .thoiGianTauChay(gaDungDTO.getThoiGianTauChay())
                .build();

        return gaDungRepository.save(entity);
    }


    @Override
    public GaDungResponse update(GaDungId id, GaDungDTO gaDungDTO) {
        return gaDungRepository.findById(id).map(existing -> {
            existing.setGioBatDauDung(gaDungDTO.getGioBatDauDung());
            existing.setGioKetThucDung(gaDungDTO.getGioKetThucDung());
            existing.setThoiGianTauChay(gaDungDTO.getThoiGianTauChay());
            return GaDungResponse.fromGaDung(gaDungRepository.save(existing));
        }).orElseThrow(() -> new RuntimeException("Không tìm thấy ga dừng"));
    }

    @Override
    public void delete(GaDungId id) {
        gaDungRepository.deleteById(id);

    }
}
