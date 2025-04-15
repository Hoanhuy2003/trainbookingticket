package com.project.tickettrainbooking.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ve_tau")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VeTau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_ve")
    private int maVe;

    @ManyToOne
    @JoinColumn(name = "ma_nguoi_dung")
    private NguoiDung nguoiDung;

    @ManyToOne
    @JoinColumn(name = "ma_chuyen_tau")
    private ChuyenTau chuyenTau;

    @ManyToOne
    @JoinColumn(name = "ma_ga_di")
    private GaTau gaDi;

    @ManyToOne
    @JoinColumn(name = "ma_ga_den")
    private GaTau gaDen;

    @ManyToOne
    @JoinColumn(name = "ma_ghe")
    private Ghe ghe;

    @ManyToOne
    @JoinColumn(name = "ma_loai_khach")
    private LoaiKhach loaiKhach;

    @Column(name = "ngay_dat")
    private LocalDateTime ngayDat;

    @ManyToOne
    @JoinColumn(name = "id_tinh_trang")
    private TinhTrangVe tinhTrangVe;
}
