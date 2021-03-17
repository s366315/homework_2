package org.hillel.homework_1;

import org.hillel.homework_1.service.InMemoryJourneyServiceImpl;
import org.hillel.homework_1.service.JourneyService;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;

@Component
public class TicketClient {
    private JourneyService journeyService;

    public TicketClient(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    public Collection<Journey> find(String stationFrom, String stationTo, LocalDate departure, LocalDate arrival) throws SQLException {
        return journeyService.find(stationFrom, stationTo, departure, arrival);
    }
/*
    public static void main(String[] args) {
        final JourneyService journeyService = new InMemoryJourneyServiceImpl();
        final TicketClient client = new TicketClient((journeyService));
        System.out.println(client.find("Odessa", "Kiev", LocalDate.now(), LocalDate.now().plusDays(1)));
        System.out.println(client.find("Odessa", "Kiev", LocalDate.now(), LocalDate.now().plusDays(3).plusDays(4)));
    }*/
}
