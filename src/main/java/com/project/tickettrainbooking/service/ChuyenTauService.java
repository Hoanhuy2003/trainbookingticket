package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.ChuyenTauDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IChuyenTauService;
import com.project.tickettrainbooking.models.ChuyenTau;
import com.project.tickettrainbooking.models.GaTau;
import com.project.tickettrainbooking.models.Tau;
import com.project.tickettrainbooking.repositorys.ChuyenTauRepository;
import com.project.tickettrainbooking.repositorys.GaTauRepository;
import com.project.tickettrainbooking.repositorys.TauRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChuyenTauService implements IChuyenTauService {
    private final ChuyenTauRepository chuyenTauRepository;
    private final GaTauRepository gaTauRepository;
    private final TauRepository tauRepository;

    public ChuyenTauService(ChuyenTauRepository chuyenTauRepository, GaTauRepository gaTauRepository, TauRepository tauRepository) {
        this.chuyenTauRepository = chuyenTauRepository;
        this.gaTauRepository = gaTauRepository;
        this.tauRepository = tauRepository;
    }


    @Override
    public ChuyenTau createChuyenTau(ChuyenTauDTO chuyenTauDTO) throws DataNotFoundException {
        Tau tau = tauRepository.findById(chuyenTauDTO.getMaTau())
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy tau co id:"+chuyenTauDTO.getMaTau()));
        GaTau gaDi = gaTauRepository.findById(chuyenTauDTO.getMaGaDi())
                .orElseThrow(() -> new DataNotFoundException("Không tìm mấy mã ga đi có id"+chuyenTauDTO.getMaGaDi()));
        GaTau gaDen = gaTauRepository.findById(chuyenTauDTO.getMaGaDen())
                .orElseThrow(()-> new DataNotFoundException("Không tìm  thấy mã ga đến có mã:"+chuyenTauDTO.getMaGaDen()));
        ChuyenTau chuyenTau = ChuyenTau.builder()
                .tau(tau)
                .gaDi(gaDi)
                .gaDen(gaDen)
                .ngayDi(chuyenTauDTO.getNgayDi())
                .ngayDen(chuyenTauDTO.getNgayDen()).build();

        return chuyenTauRepository.save(chuyenTau);
    }

    @Override
    public ChuyenTau getChuyenTauById(int id) throws DataNotFoundException {
        return chuyenTauRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy chuyến tàu"));
    }

    @Override
    public List<ChuyenTau> getAllChuyenTau() {
        return chuyenTauRepository.findAll();
    }

    @Override
    public ChuyenTau updateChuyenTau(int id, ChuyenTauDTO chuyenTauDTO) throws DataNotFoundException {
        ChuyenTau existingChuyenTau = chuyenTauRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không timg thấy chuyến tàu có id:"+id));
        Tau existingTau = tauRepository.findById(chuyenTauDTO.getMaTau())
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy ma tau có id:"+chuyenTauDTO.getMaTau()));
        GaTau existingGaDi = gaTauRepository.findById(chuyenTauDTO.getMaGaDi())
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy mã ga đi có mã:"+chuyenTauDTO.getMaGaDi()));
        GaTau existingGaDen = gaTauRepository.findById(chuyenTauDTO.getMaGaDen())
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy mã ga đen có mã:"+chuyenTauDTO.getMaGaDen()));

        existingChuyenTau.setTau(existingTau);
        existingChuyenTau.setGaDi(existingGaDi);
        existingChuyenTau.setGaDen(existingGaDen);
        existingChuyenTau.setNgayDi(chuyenTauDTO.getNgayDi());
        existingChuyenTau.setNgayDen(chuyenTauDTO.getNgayDen());
        return chuyenTauRepository.save(existingChuyenTau);
    }

    @Override
    public void deleteChuyenTau(int id) throws DataNotFoundException {
        ChuyenTau chuyenTau = getChuyenTauById(id);
        chuyenTauRepository.delete(chuyenTau);

    }
}
