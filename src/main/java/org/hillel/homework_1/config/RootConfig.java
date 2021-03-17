package org.hillel.homework_1.config;

import org.hillel.homework_1.service.DatabaseJourneyServiceImpl;
import org.hillel.homework_1.service.InMemoryJourneyServiceImpl;
import org.hillel.homework_1.service.JourneyService;
import org.hillel.homework_1.service.StubJourneyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class RootConfig {
    @Bean
    public JourneyService inMemoryJourneyService() {
        return new InMemoryJourneyServiceImpl("1");
    }

    @Bean
    public JourneyService databaseJourneyService() throws ClassNotFoundException, SQLException {
        return new DatabaseJourneyServiceImpl();
    }

    @Bean
    public JourneyService stubService() {
        return new StubJourneyServiceImpl();
    }
}
