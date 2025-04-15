package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.DatVeDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IDatVeService;
import com.project.tickettrainbooking.models.ChuyenTau;
import com.project.tickettrainbooking.models.DatVe;
import com.project.tickettrainbooking.models.NguoiDung;
import com.project.tickettrainbooking.repositorys.ChuyenTauRepository;
import com.project.tickettrainbooking.repositorys.DatVeRepository;
import com.project.tickettrainbooking.repositorys.NguoiDungRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DatVeService implements IDatVeService {
    private final DatVeRepository datVeRepository;
    private final NguoiDungRepository nguoiDungRepository;
    private final ChuyenTauRepository chuyenTauRepository;

    public DatVeService(DatVeRepository datVeRepository, NguoiDungRepository nguoiDungRepository, ChuyenTauRepository chuyenTauRepository) {
        this.datVeRepository = datVeRepository;
        this.nguoiDungRepository = nguoiDungRepository;
        this.chuyenTauRepository = chuyenTauRepository;
    }


    @Override
    public DatVe createDatVe(DatVeDTO datVeDTO) throws DataNotFoundException {
        // kiem tra nguoi dung
        NguoiDung nguoiDung = nguoiDungRepository.findById(datVeDTO.getMaHanhKhach())
                .orElseThrow(() -> new DataNotFoundException("Khong tim thay nguoi dung co id"+datVeDTO.getMaHanhKhach()));
        ChuyenTau chuyenTau = chuyenTauRepository.findById(datVeDTO.getMaChuyenTau())
                .orElseThrow(()-> new DataNotFoundException("Khong tim thay chuyen tau"+datVeDTO.getMaChuyenTau()));
        DatVe datVe = DatVe.builder()
                .nguoiDung(nguoiDung)
                .chuyenTau(chuyenTau)
                .ngayDat(datVeDTO.getNgayDat())
                .trangThai(datVeDTO.getTrangThai()).build();
        return datVeRepository.save(datVe);
    }

    @Override
    public DatVe getDatVebyId(int id) throws DataNotFoundException {

        return datVeRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("Khong tim thay"));
    }

    @Override
    public List<DatVe> getAll() {
        return datVeRepository.findAll();
    }

    @Override
    public DatVe updateDatVe(int id, DatVeDTO datVeDTO) throws DataNotFoundException {
        DatVe existingDatVe = datVeRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("Khong tim thay "));
        NguoiDung existingNguoiDung = nguoiDungRepository.findById(datVeDTO.getMaHanhKhach())
                .orElseThrow(()-> new DataNotFoundException("Khong tim thay nguoi dung"));
        ChuyenTau existingChuyenTau = chuyenTauRepository.findById(datVeDTO.getMaChuyenTau())
                .orElseThrow(()-> new DataNotFoundException("khon tim thay chuyen tau"));
        existingDatVe.setNguoiDung(existingNguoiDung);
        existingDatVe.setChuyenTau(existingChuyenTau);
        existingDatVe.setNgayDat(datVeDTO.getNgayDat());
        existingDatVe.setTrangThai(datVeDTO.getTrangThai());
        return datVeRepository.save(existingDatVe);
    }

    @Override
    public void deleteDatVe(int id) throws DataNotFoundException {
        DatVe datVe = getDatVebyId(id);
        datVeRepository.delete(datVe);

    }
}
