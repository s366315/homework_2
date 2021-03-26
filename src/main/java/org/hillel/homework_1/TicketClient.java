package org.hillel.homework_1;

import org.hillel.homework_1.persistence.entity.JourneyEntity;
import org.hillel.homework_1.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;

@Component
public class TicketClient {
//    private JourneyService journeyService;

    @Autowired
    @Qualifier(value = "transactionalJourneyService")
    private JourneyService transactionalJourneyService;

   /* public TicketClient(JourneyService journeyService) {
        this.journeyService = journeyService;
    }*/

    public int createJourney(final JourneyEntity journeyEntity) {
        return transactionalJourneyService.createJourney(journeyEntity);
    }

    public Collection<Journey> find(String stationFrom, String stationTo, LocalDate departure, LocalDate arrival) throws SQLException {
        return null;// journeyService.find(stationFrom, stationTo, departure, arrival);
    }
}
