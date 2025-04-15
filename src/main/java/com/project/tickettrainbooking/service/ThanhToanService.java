package com.project.tickettrainbooking.service;

import com.project.tickettrainbooking.dtos.ThanhToanDTO;
import com.project.tickettrainbooking.exceptions.DataNotFoundException;
import com.project.tickettrainbooking.iservice.IThanhToanService;
import com.project.tickettrainbooking.models.NguoiDung;
import com.project.tickettrainbooking.models.ThanhToan;
import com.project.tickettrainbooking.models.VeTau;
import com.project.tickettrainbooking.repositorys.NguoiDungRepository;
import com.project.tickettrainbooking.repositorys.ThanhToanRepository;
import com.project.tickettrainbooking.repositorys.VeTauRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThanhToanService implements IThanhToanService {
    private final ThanhToanRepository thanhToanRepository;
    private final NguoiDungRepository nguoiDungRepository;
    private final VeTauRepository veTauRepository;

    public ThanhToanService(ThanhToanRepository thanhToanRepository, NguoiDungRepository nguoiDungRepository, VeTauRepository veTauRepository) {
        this.thanhToanRepository = thanhToanRepository;
        this.nguoiDungRepository = nguoiDungRepository;
        this.veTauRepository = veTauRepository;
    }


    @Override
    public ThanhToan createThanhToan(ThanhToanDTO thanhToanDTO) throws DataNotFoundException {
        NguoiDung nguoiDung = nguoiDungRepository.findById(thanhToanDTO.getMaNguoiDung())
                .orElseThrow(()-> new DataNotFoundException("Không timg thấy ngườu co id"+thanhToanDTO.getMaNguoiDung()));
        VeTau veTau = veTauRepository.findById(thanhToanDTO.getMaVe())
                .orElseThrow(()-> new DataNotFoundException("Không tìm thấy ve tau có mã"+thanhToanDTO.getMaVe()));
        ThanhToan thanhToan = ThanhToan.builder()
                .nguoiDung(nguoiDung)
                .veTau(veTau)
                .ngayThanhToan(thanhToanDTO.getNgayThanhToan())
                .phuongThucThanhToan(thanhToanDTO.getPhuongThucThanhToan())
                .trangThai(thanhToanDTO.getTrangThai()).build();
        return thanhToanRepository.save(thanhToan);
    }

    @Override
    public ThanhToan confirmThanhToan(int id) throws DataNotFoundException {
        ThanhToan thanhToan = thanhToanRepository.findById(id)
                .orElseThrow(() ->new DataNotFoundException("Không hợp lệ"));
        thanhToan.setTrangThai("Đã thanh toán");
        return thanhToanRepository.save(thanhToan);
    }

    @Override
    public List<ThanhToan> getByUserId(int userId) {
        return thanhToanRepository.findByNguoiDung_MaNguoiDung(userId);
    }

    @Override
    public List<ThanhToan> getByTicketId(int ticketId) {
        return thanhToanRepository.findByVeTau_MaVe(ticketId);
    }

    @Override
    public ThanhToan updateThanhToan(int id,ThanhToanDTO thanhToanDTO) throws DataNotFoundException {
        ThanhToan exsitingThanhToan = thanhToanRepository.findById(id)
                .orElseThrow(()->new DataNotFoundException("Không hợp lệ"));
        NguoiDung exsitingNguoiDung = nguoiDungRepository.findById(thanhToanDTO.getMaNguoiDung())
                .orElseThrow(()->new DataNotFoundException("Không tìm thấy người có id:"+thanhToanDTO.getMaNguoiDung()));
        VeTau exsitingVeTau = veTauRepository.findById(thanhToanDTO.getMaVe())
                .orElseThrow(() ->new DataNotFoundException("Không tìm thấy vé tàu có id:"+thanhToanDTO.getMaVe()));
        exsitingThanhToan.setNguoiDung(exsitingNguoiDung);
        exsitingThanhToan.setVeTau(exsitingVeTau);
        exsitingThanhToan.setNgayThanhToan(thanhToanDTO.getNgayThanhToan());
        exsitingThanhToan.setSoTien(thanhToanDTO.getSoTien());
        exsitingThanhToan.setPhuongThucThanhToan(thanhToanDTO.getPhuongThucThanhToan());
        exsitingThanhToan.setTrangThai(thanhToanDTO.getTrangThai());

        return thanhToanRepository.save(exsitingThanhToan);
    }

    @Override
    public void deleteThanhToan(int id) throws DataNotFoundException {
        ThanhToan thanhToan = confirmThanhToan(id);
        thanhToanRepository.delete(thanhToan);

    }
}
