package org.hillel.homework_1.config;

import org.hillel.homework_1.persistence.repository.JourneyRepository;
import org.hillel.homework_1.persistence.repository.JourneyRepositoryImpl;
import org.hillel.homework_1.service.JourneyService;
import org.hillel.homework_1.service.TransactionalJourneyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.hillel")
@PropertySource({"database.properties"})
public class RootConfig {
    @Bean
    public JourneyService transactionalJourneyService() {
        return new TransactionalJourneyService();
    }

    @Bean
    public JourneyRepository journeyRepository() {
        return new JourneyRepositoryImpl();
    }
}
