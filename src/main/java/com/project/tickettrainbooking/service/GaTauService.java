package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.GaTauDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IGaTauService;
import com.project.tickettrainbooking.models.GaTau;
import com.project.tickettrainbooking.models.TinhTP;
import com.project.tickettrainbooking.repositorys.GaTauRepository;
import com.project.tickettrainbooking.repositorys.TinhTPRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GaTauService implements IGaTauService {
    private final GaTauRepository gaTauRepository;
    private final TinhTPRepository tinhTPRepository;

    public GaTauService(GaTauRepository gaTauRepository, TinhTPRepository tinhTPRepository) {
        this.gaTauRepository = gaTauRepository;
        this.tinhTPRepository = tinhTPRepository;
    }
    @Override
    public GaTau createGaTau(GaTauDTO gaTauDTO) throws DataNotFoundException {
        // kiem tra tinhTp
        TinhTP tinhTP = tinhTPRepository.findById(gaTauDTO.getMaTp())
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy tỉnh/ thành phố có mã:"+gaTauDTO.getMaTp()));
        GaTau gaTau = GaTau.builder()
                .tenGa(gaTauDTO.getTenGa())
                .diaChi(gaTauDTO.getDiaChi())
                .khoangCach(gaTauDTO.getKhoangCach())
                .tinhTP(tinhTP).build();


        return gaTauRepository.save(gaTau);
    }

    @Override
    public GaTau getGaTauById(Integer id) throws DataNotFoundException {
        return gaTauRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy Ga có id: "+id));
    }

    @Override
    public List<GaTau> getAllGaTau() {
        return gaTauRepository.findAll();
    }

    @Override
    public GaTau updateGaTau(Integer id, GaTauDTO gaTauDTO) throws DataNotFoundException {
        GaTau existingGaTau = gaTauRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy ga tau có id:"+id));
        TinhTP existingTinhTP = tinhTPRepository.findById(gaTauDTO.getMaTp())
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy Ga có id: "+gaTauDTO.getMaTp()));
        existingGaTau.setTenGa(gaTauDTO.getTenGa());
        existingGaTau.setDiaChi(gaTauDTO.getDiaChi());
        existingGaTau.setTinhTP(existingTinhTP);

        return gaTauRepository.save(existingGaTau);
    }

    @Override
    public void deleteGaTau(Integer id) throws DataNotFoundException {
        GaTau gaTau = getGaTauById(id);
        gaTauRepository.delete(gaTau);

    }
}
