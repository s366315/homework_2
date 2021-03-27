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
        journeyEntity.setArrival(LocalDate.now().plusDays(2));
        journeyEntity.setDeparture(LocalDate.now());
        journeyEntity.setStationTo("Jmerinka");

        System.out.println("journeyEntity was inserted with id: " + ticketClient.createJourney(journeyEntity));

        System.out.println(ticketClient.find("Kiev", "Jmerinka", LocalDate.now().minusDays(1), LocalDate.now()));
    }
}
