package com.project.tickettrainbooking.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "dat_ve")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DatVe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ma_dat_ve")
    private int maDatVe;

    @ManyToOne
    @JoinColumn(name = "ma_hanh_khach")
    private NguoiDung nguoiDung;

    @ManyToOne
    @JoinColumn(name = "ma_chuyen_tau")
    private ChuyenTau chuyenTau;

    @Column(name = "ngay_dat")
    private LocalDateTime ngayDat;

    @Column(name = "trang_thai")
    private String trangThai;

}
