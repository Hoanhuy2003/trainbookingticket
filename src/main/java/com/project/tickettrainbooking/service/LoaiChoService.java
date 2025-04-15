package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.LoaiChoDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.ILoaiChoService;
import com.project.tickettrainbooking.models.LoaiCho;
import com.project.tickettrainbooking.repositorys.LoaiChoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoaiChoService implements ILoaiChoService {
    private final LoaiChoRepository loaiChoRepository;

    public LoaiChoService(LoaiChoRepository loaiChoRepository) {
        this.loaiChoRepository = loaiChoRepository;
    }

    @Override
    public LoaiCho createLoaiCho(LoaiChoDTO loaiChoDTO) {
        LoaiCho loaiCho = new LoaiCho();
        loaiCho.setTenLoaiCho(loaiChoDTO.getTenLoaiCho());
        return loaiChoRepository.save(loaiCho);
    }

    @Override
    public LoaiCho getLoaiChoById(int id) throws DataNotFoundException {
        return loaiChoRepository.findById(id)
                .orElseThrow(()->new DataNotFoundException("not"));
    }

    @Override
    public List<LoaiCho> getAllLoaiCho() {
        return loaiChoRepository.findAll();
    }

    @Override
    public LoaiCho update(int id, LoaiChoDTO loaiChoDTO) throws DataNotFoundException {
        LoaiCho loaiCho = loaiChoRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("Khoong tim thay"));
        return loaiChoRepository.save(loaiCho);
    }

    @Override
    public void deleteLoaiCho(int id) throws DataNotFoundException {
        LoaiCho loaiCho = getLoaiChoById(id);
        loaiChoRepository.delete(loaiCho);

    }
}
