package com.project.tickettrainbooking.models;
import com.project.tickettrainbooking.enums.TrangThaiGhe;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "ghe")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ghe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_ghe")
    private int maGhe;

    @ManyToOne
    @JoinColumn(name = "ma_toa")
    private ToaTau toaTau;

    @Column(name = "so_ghe")
    private String soGhe;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai")
    private TrangThaiGhe trangThai;

}
