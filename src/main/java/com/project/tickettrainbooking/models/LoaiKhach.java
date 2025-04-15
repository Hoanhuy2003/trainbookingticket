package com.project.tickettrainbooking.models;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "loai_khach")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoaiKhach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_khach")
    private int maLoaiKhach;

    @Column(name = "ten_loai_khach")
    private String tenLoaiKhach;

    @Column(name = "phan_tram_giam_gia")
    private BigDecimal phanTramGiamGia;

}
