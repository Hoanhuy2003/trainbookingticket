package com.project.tickettrainbooking.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChuyenTauDTO {
    @JsonProperty("ma_tau")
    private Integer maTau;


    @JsonProperty("ma_ga_di")
    private Integer maGaDi;

    @JsonProperty("ma_ga_den")
    private Integer maGaDen;

    @JsonProperty("ngay_di")
    private LocalDateTime ngayDi;

    @JsonProperty("ngay_den")
    private LocalDateTime ngayDen;
}
