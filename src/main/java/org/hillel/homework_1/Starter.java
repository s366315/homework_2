package org.hillel.homework_1;

import org.hillel.homework_1.config.RootConfig;
import org.hillel.homework_1.persistence.entity.JourneyEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.time.LocalDate;

public class Starter {

    public static void main(String[] args) throws SQLException {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        TicketClient ticketClient = applicationContext.getBean(TicketClient.class);

        JourneyEntity journeyEntity = new JourneyEntity();
        journeyEntity.setStationFrom("Kiev");
        journeyEntity.setArrival(LocalDate.now().plusDays(1));
        journeyEntity.setDeparture(LocalDate.now());
        journeyEntity.setStationTo("Jmerinka");

        ticketClient.createJourney(journeyEntity);

//        ticketClient.find("Odessa", "Kiev", LocalDate.now().minusDays(2), LocalDate.now().minusDays(1));

//        System.out.println(journeyService.find("Odessa", "Kiev", LocalDate.now().minusDays(2), LocalDate.now().minusDays(1)));
//        System.out.println(journeyService.find("Lviv", "Odessa", LocalDate.now().minusDays(9), LocalDate.now()));
    }
}
