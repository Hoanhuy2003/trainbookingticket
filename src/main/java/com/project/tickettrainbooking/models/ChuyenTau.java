package com.project.tickettrainbooking.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "chuyen_tau")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChuyenTau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_chuyen_tau")
    private int maChuyenTau;

    @ManyToOne
    @JoinColumn(name = "ma_tau")
    private Tau tau;
    @ManyToOne
    @JoinColumn(name = "ma_ga_di")
    private GaTau gaDi;

    @ManyToOne
    @JoinColumn(name = "ma_ga_den")
    private GaTau gaDen;


    @Column(name = "ngay_di")
    private LocalDateTime ngayDi;

    @Column(name = "ngay_den")
    private LocalDateTime ngayDen;
}
