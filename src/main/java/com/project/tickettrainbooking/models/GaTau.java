package com.project.tickettrainbooking.models;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "ga_tau")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GaTau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ma_ga")
    private int maGa;

    @Column(name = "ten_ga")
    private String tenGa;

    @ManyToOne
    @JoinColumn(name = "ma_tp")
    private TinhTP tinhTP;

    @Column(name = "khoang_cach")
    private int khoangCach;

    @Column(name = "dia_chi")
    private String diaChi;

}
