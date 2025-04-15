package com.project.tickettrainbooking.responses;

import com.project.tickettrainbooking.enums.TrangThaiGhe;
import com.project.tickettrainbooking.models.Ghe;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GheResponse {

    private Integer maGhe;
    private String soGhe;
    private String tenToa;
    private TrangThaiGhe trangThaiGhe;

    public static GheResponse fromGhe(Ghe ghe){
        return GheResponse.builder()
                .maGhe(ghe.getMaGhe())
                .soGhe(ghe.getSoGhe())
                .tenToa(ghe.getToaTau().getTenToa())
                .trangThaiGhe(ghe.getTrangThai()).build();
    }
}
