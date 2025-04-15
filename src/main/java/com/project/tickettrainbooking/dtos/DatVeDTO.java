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
public class DatVeDTO {
    @JsonProperty("ma_hanh_khach")
    private Integer maHanhKhach;

    @JsonProperty("ma_chuyen_tau")
    private Integer maChuyenTau;

    @JsonProperty("ngay_dat")
    private LocalDateTime ngayDat;

    @JsonProperty("trang_thai")
    private String trangThai;
}
