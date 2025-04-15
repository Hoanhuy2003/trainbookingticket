package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.TinhTPDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.ITinhTPService;
import com.project.tickettrainbooking.models.TinhTP;
import com.project.tickettrainbooking.repositorys.TinhTPRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TinhTPService implements ITinhTPService {
    private final TinhTPRepository tinhTPRepository;

    public TinhTPService(TinhTPRepository tinhTPRepository) {
        this.tinhTPRepository = tinhTPRepository;
    }


    @Override
    public List<TinhTP> getAllTinhTP() {
        return tinhTPRepository.findAll();
    }

    @Override
    public TinhTP creteTinhTP(TinhTPDTO tinhTPDTO) {
        TinhTP tinhTP = new TinhTP();
        tinhTP.setTenTP(tinhTPDTO.getTenTp());
        return tinhTPRepository.save(tinhTP);
    }

    @Override
    public TinhTP getTinhTPById(Integer id) throws DataNotFoundException {
        return tinhTPRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy tỉnh/thành phố"));
    }

    @Override
    public TinhTP updateTinhTP(Integer id, TinhTPDTO tinhTPDTO) throws DataNotFoundException {
        TinhTP tinhTP = tinhTPRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy tinh/thành phố"));
        tinhTP.setTenTP(tinhTPDTO.getTenTp());
        return tinhTPRepository.save(tinhTP);
    }

    @Override
    public void deleteTinhTP(Integer id) throws DataNotFoundException {
        if (!tinhTPRepository.existsById(id)) {
            throw new DataNotFoundException("Không tìm thấy Tỉnh/Thành phố để xóa!");
        }
        tinhTPRepository.deleteById(id);

    }
}
