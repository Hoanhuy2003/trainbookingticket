package com.project.tickettrainbooking.pkfk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GaDungId implements Serializable {
    @JsonProperty("ma_ga_di")
    private Integer maGaDi;

    @JsonProperty("ma_ga_den")
    private Integer maGaDen;

    @JsonProperty("ma_tau")
    private Integer maTau;

    @JsonProperty("ma_ga_dung")
    private Integer maGaDung;
}
