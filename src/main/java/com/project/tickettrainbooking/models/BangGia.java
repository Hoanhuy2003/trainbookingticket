package com.project.tickettrainbooking.models;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bang_gia")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BangGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ma_gia")
    private int maGia;

    @ManyToOne
    @JoinColumn(name = "ma_ga_di")
    private GaTau gaDi;

    @ManyToOne
    @JoinColumn(name = "ma_ga_den")
    private GaTau gaDen;

    @ManyToOne
    @JoinColumn(name = "ma_loai_cho")
    private LoaiCho loaiCho;

    @ManyToOne
    @JoinColumn(name = "ma_tau")
    private Tau tau;

    @Column(name = "gia_tien")
    private BigDecimal giaTien;

}
