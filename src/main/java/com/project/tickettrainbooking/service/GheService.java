package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.GheDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IGheService;
import com.project.tickettrainbooking.models.Ghe;
import com.project.tickettrainbooking.models.ToaTau;
import com.project.tickettrainbooking.repositorys.GheRepository;
import com.project.tickettrainbooking.repositorys.ToaTauRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GheService implements IGheService {
    private final GheRepository gheRepository;
    private final ToaTauRepository toaTauRepository;

    public GheService(GheRepository gheRepository, ToaTauRepository toaTauRepository) {
        this.gheRepository = gheRepository;
        this.toaTauRepository = toaTauRepository;
    }

    @Override
    public Ghe createGhe(GheDTO gheDTO) throws DataNotFoundException {
        // kiểm tra toa tau
        ToaTau toaTau = toaTauRepository.findById(gheDTO.getMaToa())
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy toa tau "));
        Ghe ghe = Ghe.builder()
                .soGhe(gheDTO.getSoGhe())
                .toaTau(toaTau)
                .trangThai(gheDTO.getTrangThai()).build();
        return gheRepository.save(ghe);
    }

    @Override
    public Ghe getGheById(int id) throws DataNotFoundException {
        return gheRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy ghế có id:"+id));
    }

    @Override
    public List<Ghe> getAllGhe() {
        return gheRepository.findAll();
    }

    @Override
    public Ghe updateGhe(int id, GheDTO gheDTO) throws DataNotFoundException {
        Ghe ghe = getGheById(id);
        // kiểm tra toa tau
        ToaTau toaTau = toaTauRepository.findById(gheDTO.getMaToa())
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy toa tau"));
        ghe.setSoGhe(gheDTO.getSoGhe());
        ghe.setToaTau(toaTau);
        ghe.setTrangThai(gheDTO.getTrangThai());

        return gheRepository.save(ghe);
    }

    @Override
    public void deleteGhe(int id) throws DataNotFoundException {
        Ghe ghe =getGheById(id);
        gheRepository.delete(ghe);
    }
}
