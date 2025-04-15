package com.project.tickettrainbooking.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.tickettrainbooking.models.GaDung;
import com.project.tickettrainbooking.pkfk.GaDungId;
import lombok.*;

import java.time.LocalTime;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GaDungDTO {
    @JsonProperty("ma_ga_di")
    private Integer maGaDi;

    @JsonProperty("ma_ga_den")
    private Integer maGaDen;

    @JsonProperty("ma_tau")
    private Integer maTau;

    @JsonProperty("ma_ga_dung")
    private Integer maGaDung;

    @JsonProperty("gio_bat_dau_dung")
    private String gioBatDauDung;

    @JsonProperty("gio_ket_thuc_dung")
    private String gioKetThucDung;

    @JsonProperty("thoi_gian_tau_chay")
    private Integer thoiGianTauChay;




}
