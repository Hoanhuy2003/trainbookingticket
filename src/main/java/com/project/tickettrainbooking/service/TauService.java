package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.TauDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.ITauService;
import com.project.tickettrainbooking.models.Tau;
import com.project.tickettrainbooking.repositorys.TauRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TauService implements ITauService {
    private final TauRepository tauRepository;

    public TauService(TauRepository tauRepository) {
        this.tauRepository = tauRepository;
    }


    @Override
    public Tau createTau(TauDTO tauDTO) {
        Tau tau = new Tau();
        tau.setTenTau(tauDTO.getTenTau());
        return tauRepository.save(tau);
    }

    @Override
    public Tau getTauById(int id) throws DataNotFoundException {
        return tauRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy tàu có ID: " + id));
    }

    @Override
    public List<Tau> getAllTau() {
        return tauRepository.findAll();
    }

    @Override
    public Tau updateTau(int id, TauDTO tauDTO) throws DataNotFoundException {
        Tau tau = tauRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy tàu có ID: " + id));
        tau.setTenTau(tauDTO.getTenTau());
        return tauRepository.save(tau);
    }

    @Override
    public void deleteTau(int id) throws DataNotFoundException {
        Tau tau = getTauById(id);
        tauRepository.delete(tau);

    }
}
