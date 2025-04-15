package com.project.tickettrainbooking.repositorys;

import com.project.tickettrainbooking.models.GaDung;
import com.project.tickettrainbooking.pkfk.GaDungId;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Arrays;
import java.util.List;

public interface GaDungRepository extends JpaRepository<GaDung,GaDungId> {
    List<GaDung> findByIdMaGaDiAndIdMaGaDenAndIdMaTau(Integer maGaDi, Integer maGaDen, Integer maTau);


}
