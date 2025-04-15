package com.project.tickettrainbooking.models;

import com.project.tickettrainbooking.pkfk.ChuyenToaTauId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "chuyen_toa_tau")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChuyenToaTau {
    @EmbeddedId
    private ChuyenToaTauId id;

    @ManyToOne
    @MapsId("maChuyenTau")
    @JoinColumn(name = "ma_chuyen_tau")
    private ChuyenTau chuyenTau;

    @ManyToOne
    @MapsId("maToa")
    @JoinColumn(name = "ma_toa")
    private ToaTau toaTau;


}
