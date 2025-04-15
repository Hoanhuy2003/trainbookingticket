package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.TinhTrangVeDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.ITinhTrangVeService;
import com.project.tickettrainbooking.models.TinhTrangVe;
import com.project.tickettrainbooking.repositorys.TinhTrangVeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TinhTrangVeService implements ITinhTrangVeService {

    private final TinhTrangVeRepository tinhTrangVeRepository;

    public TinhTrangVeService(TinhTrangVeRepository tinhTrangVeRepository) {
        this.tinhTrangVeRepository = tinhTrangVeRepository;
    }


    @Override
    public TinhTrangVe createTinhTrang(TinhTrangVeDTO tinhTrangVeDTO) {
        TinhTrangVe tinhTrangVe = new TinhTrangVe();
        tinhTrangVe.setTinhTrangVe(tinhTrangVeDTO.getTinhTrangVe());
        return tinhTrangVeRepository.save(tinhTrangVe);
    }

    @Override
    public TinhTrangVe getTinhTrangById(int id) throws DataNotFoundException {
        return tinhTrangVeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy  ID: " + id));
    }

    @Override
    public List<TinhTrangVe> getAll() {
        return tinhTrangVeRepository.findAll();
    }

    @Override
    public TinhTrangVe update(int id, TinhTrangVeDTO tinhTrangVeDTO) throws DataNotFoundException {
        TinhTrangVe tinhTrangVe = tinhTrangVeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy tàu có ID: " + id));
        tinhTrangVe.setTinhTrangVe(tinhTrangVeDTO.getTinhTrangVe());
        return tinhTrangVeRepository.save(tinhTrangVe);
    }



    @Override
    public void delete(int id) throws DataNotFoundException {
        TinhTrangVe tinhTrangVe = getTinhTrangById(id);
        tinhTrangVeRepository.delete(tinhTrangVe);

    }
}
