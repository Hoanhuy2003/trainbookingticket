package com.project.tickettrainbooking.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GaTauDTO {
    @JsonProperty("ten_ga")
    private String tenGa;

    @JsonProperty("ma_tp")
    private Integer maTp;

    @JsonProperty("khoang_cach")
    private Integer khoangCach;

    @JsonProperty("dia_chi")
    private String diaChi;
}
