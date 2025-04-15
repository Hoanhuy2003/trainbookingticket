package com.project.tickettrainbooking.responses;

import com.project.tickettrainbooking.models.ChuyenTau;

import lombok.*;

import java.time.LocalDateTime;
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ChuyenTauResponse {
    private Integer maChuyenTau;
    private String tenTau;
    private String gaDi;
    private String gaDen;
    private LocalDateTime ngayDi;
    private LocalDateTime ngayDen;

    public static  ChuyenTauResponse fromChuyenTau(ChuyenTau chuyenTau){
        return ChuyenTauResponse.builder()
                .maChuyenTau(chuyenTau.getMaChuyenTau())
                .tenTau(chuyenTau.getTau().getTenTau())
                .gaDen(chuyenTau.getGaDen().getTenGa())
                .gaDi(chuyenTau.getGaDi().getTenGa())
                .ngayDi(chuyenTau.getNgayDi())
                .ngayDen(chuyenTau.getNgayDen()).build();

    }
}
