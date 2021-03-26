package org.hillel.homework_1.service;

import org.hillel.homework_1.Journey;
import org.hillel.homework_1.persistence.entity.JourneyEntity;

import java.time.LocalDate;
import java.util.*;

public class StubJourneyServiceImpl implements JourneyService {
    @Override
    public Collection<Journey> find(String stationFrom, String stationTo, LocalDate dateFrom, LocalDate dateTo) {
        return Collections.emptyList();
    }

    @Override
    public int createJourney(JourneyEntity entity) {
        return 0;
    }
}
