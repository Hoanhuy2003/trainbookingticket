package com.project.tickettrainbooking.models;
import com.project.tickettrainbooking.pkfk.GaDungId;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "ga_dung")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GaDung {
    @EmbeddedId
    private GaDungId id;

    @ManyToOne
    @MapsId("maGaDi")
    @JoinColumn(name = "ma_ga_di")
    private GaTau gaDi;

    @ManyToOne
    @MapsId("maGaDen")
    @JoinColumn(name = "ma_ga_den")
    private GaTau gaDen;

    @ManyToOne
    @MapsId("maTau")
    @JoinColumn(name = "ma_tau")
    private Tau tau;

    @ManyToOne
    @MapsId("maGaDung")
    @JoinColumn(name = "ma_ga_dung")
    private GaTau gaDung;


    @Column(name = "gio_bat_dau_dung")
    private String gioBatDauDung;

    @Column(name = "gio_ket_thuc_dung")
    private String gioKetThucDung;

    @Column(name = "thoi_gian_tau_chay")
    private int thoiGianTauChay;

}
