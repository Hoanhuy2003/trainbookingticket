package com.project.tickettrainbooking.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TinhTrangVeDTO {
    @JsonProperty("tinh_trang_ve")
    private String tinhTrangVe;
}
