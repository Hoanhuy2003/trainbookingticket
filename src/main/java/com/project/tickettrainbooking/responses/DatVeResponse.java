package com.project.tickettrainbooking.responses;

import com.project.tickettrainbooking.models.DatVe;
import lombok.*;

import java.time.LocalDateTime;
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DatVeResponse {
     private Integer maDatTau;
     private NguoiDungResponse nguoiDung;
     private ChuyenTauResponse chuyenTau;
     private LocalDateTime ngayDat;
     private String trangThai;

     public static DatVeResponse fromDatVe(DatVe datVe){
         return  DatVeResponse.builder()
                 .maDatTau(datVe.getMaDatVe())
                 .nguoiDung(NguoiDungResponse.fromNguoiDung(datVe.getNguoiDung()))
                 .chuyenTau(ChuyenTauResponse.fromChuyenTau(datVe.getChuyenTau()))
                 .ngayDat(datVe.getNgayDat())
                 .trangThai(datVe.getTrangThai()).build();
     }
}
