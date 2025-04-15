package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.ToaTauDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IToaTauService;
import com.project.tickettrainbooking.models.LoaiCho;
import com.project.tickettrainbooking.models.Tau;
import com.project.tickettrainbooking.models.ToaTau;
import com.project.tickettrainbooking.repositorys.LoaiChoRepository;
import com.project.tickettrainbooking.repositorys.TauRepository;
import com.project.tickettrainbooking.repositorys.ToaTauRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ToaTauService implements IToaTauService {
    private final ToaTauRepository toaTauRepository;
    private final TauRepository tauRepository;
    private final LoaiChoRepository loaiChoRepository;

    public ToaTauService(ToaTauRepository toaTauRepository, TauRepository tauRepository, LoaiChoRepository loaiChoRepository) {
        this.toaTauRepository = toaTauRepository;
        this.tauRepository = tauRepository;
        this.loaiChoRepository = loaiChoRepository;
    }


    @Override
    public ToaTau createToaTau(ToaTauDTO toaTauDTO) throws DataNotFoundException {
        Tau tau = tauRepository.findById(toaTauDTO.getMaTau())
                .orElseThrow(()->new DataNotFoundException("Không tìm thấy tàu có mã:"+toaTauDTO.getMaTau()));

        LoaiCho loaiCho = loaiChoRepository.findById(toaTauDTO.getMaLoaiCho())
                .orElseThrow(() -> new DataNotFoundException("Không tìm thâ loại chỗ có id:"+toaTauDTO.getMaLoaiCho()));
        ToaTau toaTau = ToaTau.builder()
                .tau(tau)
                .tenToa(toaTauDTO.getTenToa())
                .loaiCho(loaiCho)
                .soCho(toaTauDTO.getSoCho()).build();

        return toaTauRepository.save(toaTau);
    }

    @Override
    public ToaTau getToaTauById(int id) throws DataNotFoundException {
        return toaTauRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy toa tàu có mã:"+id));
    }

    @Override
    public List<ToaTau> getAllToaTau() {
        return toaTauRepository.findAll();
    }

    @Override
    public ToaTau updateToaTau(int id, ToaTauDTO toaTauDTO) throws DataNotFoundException {
        ToaTau toaTau = getToaTauById(id);

        Tau tau = tauRepository.findById(toaTauDTO.getMaTau())
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy tau"));
        LoaiCho loaiCho = loaiChoRepository.findById(toaTauDTO.getMaLoaiCho())
                        .orElseThrow(() -> new DataNotFoundException("Không tìm thâyy"));
        toaTau.setTau(tau);
        toaTau.setTenToa(toaTauDTO.getTenToa());
        toaTau.setLoaiCho(loaiCho);
        toaTau.setSoCho(toaTauDTO.getSoCho());
        return toaTauRepository.save(toaTau);
    }

    @Override
    public void deleteToaTau(int id) throws DataNotFoundException {
        ToaTau toaTau = getToaTauById(id);
        toaTauRepository.delete(toaTau);

    }
}
