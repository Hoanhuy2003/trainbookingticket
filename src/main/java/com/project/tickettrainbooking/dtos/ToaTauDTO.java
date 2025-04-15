package com.project.tickettrainbooking.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToaTauDTO {
    @JsonProperty("ten_toa")
    private String tenToa;

    @JsonProperty("ma_tau")
    private Integer maTau;

    @JsonProperty("ma_loai_cho")
    private Integer maLoaiCho;

    @JsonProperty("so_cho")
    private Integer soCho;
}
