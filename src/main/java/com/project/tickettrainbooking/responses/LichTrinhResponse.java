package com.project.tickettrainbooking.responses;

import com.project.tickettrainbooking.models.LichTrinh;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LichTrinhResponse {
    private int maGaDi;
    private String tenGaDi;
    private int maGaDen;
    private String tenGaDen;
    private String gioDi;
    private String gioDen;
    private int soGioDi;

    public static LichTrinhResponse fromLichTrinh(LichTrinh lichTrinh){
        return LichTrinhResponse.builder()
                .maGaDi(lichTrinh.getId().getMaGaDi())
                .tenGaDi(lichTrinh.getGaDi().getTenGa())
                .maGaDen(lichTrinh.getId().getMaGaDen())
                .tenGaDen(lichTrinh.getGaDen().getTenGa())
                .gioDi(lichTrinh.getGioDi())
                .gioDen(lichTrinh.getGioDen())
                .soGioDi(lichTrinh.getSoGioDi())
                .build();
    }
}
