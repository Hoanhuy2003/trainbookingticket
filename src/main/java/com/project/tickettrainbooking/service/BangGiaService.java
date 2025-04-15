package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.BangGiaDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IBangGiaService;
import com.project.tickettrainbooking.models.BangGia;
import com.project.tickettrainbooking.models.GaTau;
import com.project.tickettrainbooking.models.LoaiCho;
import com.project.tickettrainbooking.models.Tau;
import com.project.tickettrainbooking.repositorys.BangGiaRepository;
import com.project.tickettrainbooking.repositorys.GaTauRepository;
import com.project.tickettrainbooking.repositorys.LoaiChoRepository;
import com.project.tickettrainbooking.repositorys.TauRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BangGiaService implements IBangGiaService {
    private final BangGiaRepository bangGiaRepository;
    private final GaTauRepository gaTauRepository;
    private final TauRepository tauRepository;
    private final LoaiChoRepository loaiChoRepository;

    public BangGiaService(BangGiaRepository bangGiaRepository, GaTauRepository gaTauRepository, TauRepository tauRepository, LoaiChoRepository loaiChoRepository) {
        this.bangGiaRepository = bangGiaRepository;
        this.gaTauRepository = gaTauRepository;
        this.tauRepository = tauRepository;
        this.loaiChoRepository = loaiChoRepository;
    }

    @Override
    public BangGia createBangGia(BangGiaDTO bangGiaDTO) throws DataNotFoundException {
        GaTau gaDi = gaTauRepository.findById(bangGiaDTO.getMaGaDi())
                .orElseThrow(() -> new DataNotFoundException("Khoong tim thấy ngay đi"));
        GaTau gaDen = gaTauRepository.findById(bangGiaDTO.getMaGaDen())
                .orElseThrow(() -> new DataNotFoundException("Khoong tim thấy ngay đen"));
        Tau tau = tauRepository.findById(bangGiaDTO.getMaTau())
                .orElseThrow(() -> new DataNotFoundException("Khoong tim thấy tau"));
        LoaiCho loaiCho = loaiChoRepository.findById(bangGiaDTO.getMaLoaiCho())
                .orElseThrow(() -> new DataNotFoundException("Khoong tim thấy tau"));
        BangGia bangGia = BangGia.builder()
                .gaDi(gaDi)
                .gaDen(gaDen)
                .tau(tau)
                .loaiCho(loaiCho)
                .giaTien(bangGiaDTO.getGiaTien()).build();

        return bangGiaRepository.save(bangGia);
    }

    @Override
    public BangGia getBangGiaById(int id) throws DataNotFoundException {
        return bangGiaRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy bảng giá có id"+id));
    }

    @Override
    public List<BangGia> getAllBangGia() {
        return bangGiaRepository.findAll();
    }

    @Override
    public BangGia updateBangGia(int id, BangGiaDTO bangGiaDTO) throws DataNotFoundException {
        BangGia existingBangGia = bangGiaRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không timg thấy bảng có id"+id));
        Tau existingTau = tauRepository.findById(bangGiaDTO.getMaTau())
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy ma tau có id:"+bangGiaDTO.getMaTau()));
        GaTau existingGaDi = gaTauRepository.findById(bangGiaDTO.getMaGaDi())
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy mã ga đi có mã:"+bangGiaDTO.getMaGaDi()));
        GaTau existingGaDen = gaTauRepository.findById(bangGiaDTO.getMaGaDen())
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy mã ga đen có mã:"+bangGiaDTO.getMaGaDen()));
        LoaiCho existingLoaiCho = loaiChoRepository.findById(bangGiaDTO.getMaLoaiCho())
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy loai cho có mã:"+bangGiaDTO.getMaLoaiCho()));

        existingBangGia.setTau(existingTau);
        existingBangGia.setGaDi(existingGaDi);
        existingBangGia.setGaDen(existingGaDen);
        existingBangGia.setLoaiCho(existingLoaiCho);
        existingBangGia.setGiaTien(bangGiaDTO.getGiaTien());

        return bangGiaRepository.save(existingBangGia);
    }

    @Override
    public void deleteBangGia(int id) throws DataNotFoundException {
        BangGia bangGia = getBangGiaById(id);
        bangGiaRepository.delete(bangGia);

    }
}
