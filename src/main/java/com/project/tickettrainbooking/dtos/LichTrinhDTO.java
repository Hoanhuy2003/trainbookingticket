package com.project.tickettrainbooking.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalTime;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LichTrinhDTO {
    @JsonProperty("ma_ga_di")
    private Integer maGaDi;

    @JsonProperty("ma_ga_den")
    private Integer maGaDen;

    @JsonProperty("gio_di")
    private LocalTime gioDi;

    @JsonProperty("gio_den")
    private LocalTime gioDen;

    @JsonProperty("so_gio_di")
    private Integer soGioDi;
}
