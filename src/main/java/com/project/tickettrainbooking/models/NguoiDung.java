package com.project.tickettrainbooking.models;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "nguoi_dung")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ma_nguoi_dung")
    private int maNguoiDung;

    @Column(name = "ten_dang_nhap")
    private String tenDangNhap;

    @Column(name = "mat_khau")
    private String matKhau;

    private String role;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;
    private String email;
    private String cccd;

}
