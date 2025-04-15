package com.project.tickettrainbooking.responses;

import com.project.tickettrainbooking.models.ThanhToan;
import lombok.*;

import java.math.BigDecimal;
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ThanhToanResponse {
    private int maThanhToan;
    private int maVe;
    private String hoTen;
    private BigDecimal soTien;
    private String phuongThucThanhToan;
    private String trangThai;

    public static ThanhToanResponse fromThanhToan(ThanhToan thanhToan){
        return ThanhToanResponse.builder()
                .maThanhToan(thanhToan.getMaThanhToan())
                .maVe(thanhToan.getVeTau().getMaVe())
                .hoTen(thanhToan.getNguoiDung().getHoTen())
                .soTien(thanhToan.getSoTien())
                .phuongThucThanhToan(thanhToan.getPhuongThucThanhToan())
                .trangThai(thanhToan.getTrangThai()).build();
    }
}
