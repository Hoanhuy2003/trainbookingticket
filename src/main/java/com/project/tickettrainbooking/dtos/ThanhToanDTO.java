package com.project.tickettrainbooking.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ThanhToanDTO {
    @JsonProperty("ma_ve")
    private Integer maVe;

    @JsonProperty("ma_nguoi_dung")
    private Integer maNguoiDung;

    @JsonProperty("ngay_thanh_toan")
    private LocalDateTime ngayThanhToan;

    @JsonProperty("so_tien")
    private BigDecimal soTien;

    @JsonProperty("phuong_thuc_thanh_toan")
    private String phuongThucThanhToan;

    @JsonProperty("trang_thai")
    private String trangThai;
}
