package com.project.tickettrainbooking.repositorys;

import com.project.tickettrainbooking.models.ThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThanhToanRepository extends JpaRepository<ThanhToan,Integer> {
    List<ThanhToan> findByNguoiDung_MaNguoiDung(Integer userId);
    List<ThanhToan> findByVeTau_MaVe(Integer maVe);
}
