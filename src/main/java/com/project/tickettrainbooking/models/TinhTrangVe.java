package com.project.tickettrainbooking.models;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "tinh_trang_ve")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TinhTrangVe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;

    @Column(name = "tinh_trang_ve")
    private String tinhTrangVe;

}
