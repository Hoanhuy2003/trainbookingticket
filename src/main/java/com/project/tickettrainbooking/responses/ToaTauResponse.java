package com.project.tickettrainbooking.responses;

import com.project.tickettrainbooking.models.ToaTau;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToaTauResponse {
    private int maToa;
    private String tenToa;
    private String tenLoaiCho;
    private String tenTau;
    private Integer soCho;

    public static ToaTauResponse fromToaTau(ToaTau toaTau){
        return ToaTauResponse.builder()
                .maToa(toaTau.getMaToa())
                .tenToa(toaTau.getTenToa())
                .tenTau(toaTau.getTau().getTenTau())
                .tenLoaiCho(toaTau.getLoaiCho().getTenLoaiCho())
                .soCho(toaTau.getSoCho()).build();
    }
}
