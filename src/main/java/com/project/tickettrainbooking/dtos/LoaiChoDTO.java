package com.project.tickettrainbooking.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoaiChoDTO {

    @JsonProperty("ten_loai_cho")
    private String tenLoaiCho;
}
