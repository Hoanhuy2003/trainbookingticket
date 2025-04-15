package com.project.tickettrainbooking.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChuyenToaTauDTO {
    @JsonProperty("ma_chuyen_tau")
    private Integer maChuyenTau;

    @JsonProperty("ma_toa")
    private Integer maToa;
}
