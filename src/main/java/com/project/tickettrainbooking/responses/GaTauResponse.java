package com.project.tickettrainbooking.responses;

import com.project.tickettrainbooking.models.GaTau;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GaTauResponse {
    private int maGa;
    private String tenGa;
    private String diaChi;
    private int khoangCach;
    private String tenTP;

    public static  GaTauResponse fromGaTau(GaTau gaTau){
        return GaTauResponse.builder()
                .maGa(gaTau.getMaGa())
                .tenGa(gaTau.getTenGa())
                .diaChi(gaTau.getDiaChi())
                .khoangCach(gaTau.getKhoangCach())
                .tenTP(gaTau.getTinhTP().getTenTP()).build();
    }
}
