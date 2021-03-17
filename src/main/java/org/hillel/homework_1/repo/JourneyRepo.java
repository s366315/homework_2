package org.hillel.homework_1.repo;

import org.hillel.homework_1.Journey;

import java.sql.SQLException;
import java.util.List;

public interface JourneyRepo {
    List<Journey> getJourneys() throws SQLException;

    Journey getJourney(int id) throws SQLException;

    boolean deleteJourney(Journey journey);

    boolean saveJourney(Journey journey);
}
