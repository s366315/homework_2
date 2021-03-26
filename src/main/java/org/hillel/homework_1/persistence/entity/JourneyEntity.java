package org.hillel.homework_1.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class JourneyEntity {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @Column(name = "station_from")
    private String stationFrom;

    @Getter
    @Setter
    @Column(name = "station_to")
    private String stationTo;

    @Getter
    @Setter
    private LocalDate departure;

    @Getter
    @Setter
    private LocalDate arrival;

    @Getter
    private String route;

    public JourneyEntity() {
    }
}
