package org.hillel.homework_1;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
public class Journey {
    @Getter
    private String stationFrom;
    @Getter
    private String stationTo;
    @Getter
    private LocalDate departure;
    @Getter
    private LocalDate arrival;
    private String route;

    public Journey(final String stationFrom, final String stationTo, final LocalDate departure, final LocalDate arrival) {
        if (stationFrom == null) throw new IllegalArgumentException("station from must be a set");
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
        this.departure = departure;
        this.arrival = arrival;
        this.route = stationFrom + "->" + stationTo;
    }

    public Journey() {

    }
}
