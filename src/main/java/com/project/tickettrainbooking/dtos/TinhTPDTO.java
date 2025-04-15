package com.project.tickettrainbooking.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TinhTPDTO {
    @JsonProperty("ten_tp")
    private String tenTp;
}
