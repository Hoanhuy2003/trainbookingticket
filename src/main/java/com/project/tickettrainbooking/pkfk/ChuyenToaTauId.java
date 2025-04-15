package com.project.tickettrainbooking.pkfk;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChuyenToaTauId  implements Serializable {
    private Integer maChuyenTau;
    private Integer maToa;
}
