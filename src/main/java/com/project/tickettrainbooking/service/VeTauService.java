package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.TinhTrangVeDTO;
import com.project.tickettrainbooking.dtos.VeTauDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IVeTauService;
import com.project.tickettrainbooking.models.*;
import com.project.tickettrainbooking.repositorys.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VeTauService implements IVeTauService {
    private final VeTauRepository veTauRepository;
    private final NguoiDungRepository nguoiDungRepository;
    private final ChuyenTauRepository chuyenTauRepository;
    private final GaTauRepository gaTauRepository;
    private final GheRepository gheRepository;
    private final LoaiKhachRepository loaiKhachRepository;
    private final TinhTrangVeRepository tinhTrangVeRepository;

    public VeTauService(VeTauRepository veTauRepository, NguoiDungRepository nguoiDungRepository, ChuyenTauRepository chuyenTauRepository, GaTauRepository gaTauRepository, GheRepository gheRepository, LoaiKhachRepository loaiKhachRepository, TinhTrangVeRepository tinhTrangVeRepository) {
        this.veTauRepository = veTauRepository;
        this.nguoiDungRepository = nguoiDungRepository;
        this.chuyenTauRepository = chuyenTauRepository;
        this.gaTauRepository = gaTauRepository;
        this.gheRepository = gheRepository;
        this.loaiKhachRepository = loaiKhachRepository;
        this.tinhTrangVeRepository = tinhTrangVeRepository;
    }

    @Override
    public VeTau createVeTau(VeTauDTO veTauDTO) throws DataNotFoundException {
        // kiểm tra người dùng
        NguoiDung nguoiDung = nguoiDungRepository.findById(veTauDTO.getMaNguoiDung())
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy người dùng"));
        ChuyenTau chuyenTau = chuyenTauRepository.findById(veTauDTO.getMaChuyenTau())
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy chuyến tàu"));
        GaTau gaDi = gaTauRepository.findById(veTauDTO.getMaGaDi())
                .orElseThrow(() -> new DataNotFoundException("Không tìm mấy mã ga đi có id"+veTauDTO.getMaGaDi()));
        GaTau gaDen = gaTauRepository.findById(veTauDTO.getMaGaDen())
                .orElseThrow(()-> new DataNotFoundException("Không tìm  thấy mã ga đến có mã:"+veTauDTO.getMaGaDen()));
        Ghe ghe = gheRepository.findById(veTauDTO.getMaGhe())
                .orElseThrow(() -> new DataNotFoundException("Không tim thấy ghế có mã:"+veTauDTO.getMaGhe()));
        LoaiKhach loaiKhach = loaiKhachRepository.findById(veTauDTO.getMaLoaiKhach())
                .orElseThrow(() -> new DataNotFoundException("Không tim thấy loai khach"));
        TinhTrangVe tinhTrangVe = tinhTrangVeRepository.findById(veTauDTO.getIdTinhTrang())
                .orElseThrow(() -> new DataNotFoundException("not"));
        VeTau veTau = VeTau.builder()
                .nguoiDung(nguoiDung)
                .chuyenTau(chuyenTau)
                .gaDi(gaDi)
                .gaDen(gaDen)
                .ghe(ghe)
                .loaiKhach(loaiKhach)
                .ngayDat(veTauDTO.getNgayDat())
                .tinhTrangVe(tinhTrangVe).build();

        return veTauRepository.save(veTau);
    }

    @Override
    public VeTau getVeTauById(int id) throws DataNotFoundException {
        return veTauRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy"));
    }

    @Override
    public List<VeTau> getAllVeTau() {
        return veTauRepository.findAll();
    }

    @Override
    public VeTau updateVeTau(int id, VeTauDTO veTauDTO) throws DataNotFoundException {
        VeTau existingVeTau = veTauRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Khoong tìm thấy"));
        NguoiDung existingNguoiDung = nguoiDungRepository.findById(veTauDTO.getMaNguoiDung())
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy người dùng"));
        ChuyenTau existingChuyenTau = chuyenTauRepository.findById(veTauDTO.getMaChuyenTau())
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy chuyến tàu"));
        GaTau existingGaDi = gaTauRepository.findById(veTauDTO.getMaGaDi())
                .orElseThrow(() -> new DataNotFoundException("Không tìm mấy mã ga đi có id"+veTauDTO.getMaGaDi()));
        GaTau existingGaDen = gaTauRepository.findById(veTauDTO.getMaGaDen())
                .orElseThrow(()-> new DataNotFoundException("Không tìm  thấy mã ga đến có mã:"+veTauDTO.getMaGaDen()));
        Ghe existingGhe = gheRepository.findById(veTauDTO.getMaGhe())
                .orElseThrow(() -> new DataNotFoundException("Không tim thấy ghế có mã:"+veTauDTO.getMaGhe()));
        LoaiKhach existingLoaiKhach = loaiKhachRepository.findById(veTauDTO.getMaLoaiKhach())
                .orElseThrow(() -> new DataNotFoundException("Không tim thấy loai khach"));
        TinhTrangVe existingTinhTrangVe = tinhTrangVeRepository.findById(veTauDTO.getIdTinhTrang())
                .orElseThrow(() -> new DataNotFoundException("not"));

        existingVeTau.setNguoiDung(existingNguoiDung);
        existingVeTau.setChuyenTau(existingChuyenTau);
        existingVeTau.setGaDi(existingGaDi);
        existingVeTau.setGaDen(existingGaDen);
        existingVeTau.setGhe(existingGhe);
        existingVeTau.setLoaiKhach(existingLoaiKhach);
        existingVeTau.setTinhTrangVe(existingTinhTrangVe);


        return veTauRepository.save(existingVeTau);
    }

    @Override
    public void deleteVeTau(int id) throws DataNotFoundException {
        VeTau veTau = getVeTauById(id);
        veTauRepository.delete(veTau);

    }
}
