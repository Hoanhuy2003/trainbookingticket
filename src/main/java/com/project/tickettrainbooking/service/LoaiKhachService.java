package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.LoaiKhachDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.ILoaiKhachService;
import com.project.tickettrainbooking.models.LoaiKhach;
import com.project.tickettrainbooking.repositorys.LoaiKhachRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoaiKhachService implements ILoaiKhachService {
    private final LoaiKhachRepository loaiKhachRepository;

    public LoaiKhachService(LoaiKhachRepository loaiKhachRepository) {
        this.loaiKhachRepository = loaiKhachRepository;
    }

    @Override
    public LoaiKhach createLoaiKhach(LoaiKhachDTO loaiKhachDTO) {
        LoaiKhach loaiKhach = new LoaiKhach();
        loaiKhach.setTenLoaiKhach(loaiKhachDTO.getTenLoaiKhach());
        loaiKhach.setPhanTramGiamGia(loaiKhachDTO.getPhanTramGiamGia());
        return loaiKhachRepository.save(loaiKhach);
    }

    @Override
    public LoaiKhach getLoaiKhachById(int id) throws DataNotFoundException {
        return loaiKhachRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy loại khách có ID: " + id));
    }

    @Override
    public List<LoaiKhach> getAllLoaiKhach() {
        return loaiKhachRepository.findAll();
    }

    @Override
    public LoaiKhach updateLoaiKhach(int id, LoaiKhachDTO loaiKhachDTO) throws DataNotFoundException {
        LoaiKhach loaiKhach = loaiKhachRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy loại khách có ID: " + id));
        loaiKhach.setTenLoaiKhach(loaiKhachDTO.getTenLoaiKhach());
        loaiKhach.setPhanTramGiamGia(loaiKhachDTO.getPhanTramGiamGia());
        return loaiKhachRepository.save(loaiKhach);
    }

    @Override
    public void deleteLoaiKhach(int id) throws DataNotFoundException {
        LoaiKhach loaiKhach = getLoaiKhachById(id);
        loaiKhachRepository.delete(loaiKhach);

    }
}
