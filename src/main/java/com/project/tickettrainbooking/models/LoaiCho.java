package com.project.tickettrainbooking.models;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "loai_cho")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoaiCho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ma_loai_cho")
    private int maLoaiCho;

    @Column(name = "ten_loai_cho")
    private String tenLoaiCho;

}
