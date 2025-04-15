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
public class VeTauDTO {
    @JsonProperty("ma_nguoi_dung")
    private Integer maNguoiDung;

    @JsonProperty("ma_chuyen_tau")
    private Integer maChuyenTau;

    @JsonProperty("ma_ga_di")
    private Integer maGaDi;

    @JsonProperty("ma_ga_den")
    private Integer maGaDen;

    @JsonProperty("ma_ghe")
    private Integer maGhe;

    @JsonProperty("ma_loai_khach")
    private Integer maLoaiKhach;

    @JsonProperty("ngay_dat")
    private LocalDateTime ngayDat;

    @JsonProperty("id_tinh_trang")
    private Integer idTinhTrang;
}
