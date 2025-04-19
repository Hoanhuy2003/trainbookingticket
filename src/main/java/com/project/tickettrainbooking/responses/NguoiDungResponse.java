package com.project.tickettrainbooking.responses;

import com.project.tickettrainbooking.models.NguoiDung;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDungResponse {
    private Integer maNguoiDung;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String cccd;

    public  static NguoiDungResponse fromNguoiDung(NguoiDung nguoiDung){
        return NguoiDungResponse.builder()
                .maNguoiDung(nguoiDung.getMaNguoiDung())
                .hoTen(nguoiDung.getHoTen())
                .email(nguoiDung.getEmail())
                .soDienThoai(nguoiDung.getSoDienThoai())
                .cccd(nguoiDung.getCccd()).build();
    }




}
