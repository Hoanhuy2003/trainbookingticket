package com.project.tickettrainbooking.repositorys;

import com.project.tickettrainbooking.models.LichTrinh;
import com.project.tickettrainbooking.pkfk.LichTrinhId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LichTrinhRepository extends JpaRepository<LichTrinh, Integer> {
    Optional<LichTrinh> findById(LichTrinhId lichTrinh);
}
