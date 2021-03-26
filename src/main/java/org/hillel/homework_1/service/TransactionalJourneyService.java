package org.hillel.homework_1.service;

import org.hillel.homework_1.Journey;
import org.hillel.homework_1.persistence.entity.JourneyEntity;
import org.hillel.homework_1.persistence.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;

@Service("transactionalJourneyService")
public class TransactionalJourneyService implements JourneyService {

    @Autowired
    @Qualifier("journeyRepository")
    private JourneyRepository journeyRepository;

    @Override
    public Collection<Journey> find(String stationFrom, String stationTo, LocalDate dateFrom, LocalDate dateTo) throws SQLException {
        return null;
    }

    @Transactional
    @Override
    public int createJourney(final JourneyEntity entity) {
        return journeyRepository.create(entity);
    }
}
