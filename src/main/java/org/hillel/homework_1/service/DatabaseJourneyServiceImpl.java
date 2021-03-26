package org.hillel.homework_1.service;

import org.hillel.homework_1.Journey;
import org.hillel.homework_1.persistence.entity.JourneyEntity;
import org.hillel.homework_1.repo.JourneyRepo;
import org.hillel.homework_1.repo.JourneyRepoImpl;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class DatabaseJourneyServiceImpl implements JourneyService {

    private final JourneyRepo repo;

    public DatabaseJourneyServiceImpl() throws SQLException, ClassNotFoundException {
        repo = new JourneyRepoImpl();
    }

    @Override
    public Collection<Journey> find(String stationFrom, String stationTo, LocalDate dateFrom, LocalDate dateTo) throws SQLException {
        List<Journey> out = new ArrayList<>();
        for (Journey item : repo.getJourneys()) {
            if (item.getDeparture().equals(dateFrom) &&
                    item.getArrival().equals(dateTo) &&
                    item.getStationFrom().equals(stationFrom) &&
                    item.getStationTo().equals(stationTo)) {
                out.add(item);
            }
        }
        return Collections.unmodifiableList(out);
    }

    @Override
    public int createJourney(JourneyEntity entity) {
        return 0;
    }
}
