package com.project.tickettrainbooking.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BangGiaDTO {
    @JsonProperty("ma_ga_di")
    private Integer maGaDi;

    @JsonProperty("ma_ga_den")
    private Integer maGaDen;

    @JsonProperty("ma_loai_cho")
    private Integer maLoaiCho;

    @JsonProperty("ma_tau")
    private Integer maTau;

    @JsonProperty("gia_tien")
    private BigDecimal giaTien;
}
