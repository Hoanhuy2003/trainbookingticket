package com.project.tickettrainbooking.responses;

import com.project.tickettrainbooking.models.VeTau;
import lombok.*;

import java.time.LocalDateTime;
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VeTauResponse {
    private int maVeTau;
    private String hoVaTen;
    private int tenChuyenTau;
    private String gaDi;
    private String gaDen;
    private String ghe;
    private String loaiKhach;
    private LocalDateTime ngayDat;
    private String tinhTrangVe;

    public static VeTauResponse fromVeTau(VeTau veTau){
        return VeTauResponse.builder()
                .maVeTau(veTau.getMaVe())
                .hoVaTen(veTau.getNguoiDung().getHoTen())
                .tenChuyenTau(veTau.getChuyenTau().getMaChuyenTau())
                .gaDi(veTau.getGaDi().getTenGa())
                .gaDen(veTau.getGaDen().getTenGa())
                .ghe(veTau.getGhe().getSoGhe())
                .loaiKhach(veTau.getLoaiKhach().getTenLoaiKhach())
                .ngayDat(veTau.getNgayDat())
                .tinhTrangVe(veTau.getTinhTrangVe().getTinhTrangVe()).build();
    }


}
