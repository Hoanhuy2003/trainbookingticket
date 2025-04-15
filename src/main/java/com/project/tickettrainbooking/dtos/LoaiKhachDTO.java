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
public class LoaiKhachDTO {
    @JsonProperty("ten_loai_khach")
    private String tenLoaiKhach;

    @JsonProperty("phan_tram_giam_gia")
    private BigDecimal phanTramGiamGia;

}
