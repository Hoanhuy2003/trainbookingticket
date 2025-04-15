package com.project.tickettrainbooking.models;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "tinh_thanh_pho")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TinhTP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_tp")
    private int maTP;

    @Column(name = "ten_tp")
    private String tenTP;

}
