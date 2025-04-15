package com.project.tickettrainbooking.models;
import com.project.tickettrainbooking.pkfk.LichTrinhId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "lich_trinh")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LichTrinh {

    @EmbeddedId
    private LichTrinhId id;

    @ManyToOne
    @MapsId("maGaDi")
    @JoinColumn(name = "ma_ga_di")
    private GaTau gaDi;

    @ManyToOne
    @MapsId("maGaDen")
    @JoinColumn(name = "ma_ga_den")
    private GaTau gaDen;


    @Column(name = "gio_di")
    private String gioDi;

    @Column(name = "gio_den")
    private String gioDen;

    @Column(name = "so_gio_di")
    private int soGioDi;
}
