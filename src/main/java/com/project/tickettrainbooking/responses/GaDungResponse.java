package com.project.tickettrainbooking.responses;

import com.project.tickettrainbooking.models.GaDung;
import lombok.*;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GaDungResponse {
    private String gaDi;
    private String gaDen;
    private String tenTau;
    private String tenGaDung;
    private String gioBatDauDung;
    private String gioKetThucDung;
    private Integer thoiGianTauChay;

    public static GaDungResponse fromGaDung(GaDung gaDung) {
        return GaDungResponse.builder()
                .gaDi(gaDung.getGaDi().getTenGa())
                .gaDen(gaDung.getGaDen().getTenGa())
                .tenTau(gaDung.getTau().getTenTau())
                .tenGaDung(gaDung.getGaDung().getTenGa())
                .gioBatDauDung(gaDung.getGioBatDauDung())
                .gioKetThucDung(gaDung.getGioKetThucDung())
                .thoiGianTauChay(gaDung.getThoiGianTauChay()).build();
    }


}
