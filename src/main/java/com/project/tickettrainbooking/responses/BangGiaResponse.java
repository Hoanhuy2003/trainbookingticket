package com.project.tickettrainbooking.responses;

import com.project.tickettrainbooking.models.BangGia;
import lombok.*;

import java.math.BigDecimal;
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BangGiaResponse {

    private Integer maGia;
    private String tenTau;
    private String gaDi;
    private String gaDen;
    private String tenLoaiCho;
    private BigDecimal giaTien;

    public static BangGiaResponse fromBangGia(BangGia bangGia){
        return  BangGiaResponse.builder()
                .maGia(bangGia.getMaGia())
                .tenTau(bangGia.getTau().getTenTau())
                .gaDi(bangGia.getGaDi().getTenGa())
                .gaDen(bangGia.getGaDen().getTenGa())
                .tenLoaiCho(bangGia.getLoaiCho().getTenLoaiCho())
                .giaTien(bangGia.getGiaTien()).build();

    }
}
