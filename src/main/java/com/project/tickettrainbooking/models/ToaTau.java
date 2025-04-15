package com.project.tickettrainbooking.models;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "toa_tau")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToaTau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_toa")
    private int maToa;

    @Column(name = "ten_toa")
    private String tenToa;

    @ManyToOne
    @JoinColumn(name = "ma_loai_cho")
    private LoaiCho loaiCho;


    @ManyToOne
    @JoinColumn(name = "ma_tau")
    private Tau tau;


    @Column(name = "so_cho")
    private int soCho;


}
