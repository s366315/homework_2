package org.hillel.homework_1.config;

import org.hillel.homework_1.persistence.repository.JourneyRepository;
import org.hillel.homework_1.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.SQLException;

@Configuration
@ComponentScan("org.hillel")
@PropertySource({"database.properties"})
public class RootConfig {
    @Bean
    public JourneyService databaseJourneyService() throws ClassNotFoundException, SQLException {
        return new DatabaseJourneyServiceImpl();
    }

    @Bean
    public JourneyService transactionalJourneyService() {
        return new TransactionalJourneyService();
    }

    @Bean
    public JourneyRepository journeyRepository() {
        return new JourneyRepository();
    }
}
