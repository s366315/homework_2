package org.hillel.homework_1.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@ToString
@Table(name = "homework_1")
public class JourneyEntity {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
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
    @Column(name = "date_from")
    private LocalDate departure;

    @Getter
    @Setter
    @Column(name = "date_to")
    private LocalDate arrival;

    @Getter
    @Transient
    private String route;

    public JourneyEntity() {
    }
}
