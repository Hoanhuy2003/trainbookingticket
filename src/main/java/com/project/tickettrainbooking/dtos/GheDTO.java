package com.project.tickettrainbooking.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.tickettrainbooking.enums.TrangThaiGhe;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GheDTO {
    @JsonProperty("ma_toa")
    private Integer maToa;

    @JsonProperty("so_ghe")
    private String soGhe;

    @JsonProperty("trang_thai")
    private TrangThaiGhe trangThai;
}
