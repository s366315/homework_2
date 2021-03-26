package org.hillel.homework_1.service;

import org.hillel.homework_1.Journey;
import org.hillel.homework_1.persistence.entity.JourneyEntity;

import java.time.LocalDate;
import java.util.*;

public class InMemoryJourneyServiceImpl implements JourneyService<Journey> {

    private Map<String, List<Journey>> storage = new HashMap<>();
    private final String id;
    public InMemoryJourneyServiceImpl(final String identify) {

        id = identify;
    }

    {
        storage.put("Odessa->Kiev", createJourney("Odessa", "Kiev"));
        storage.put("Kiev->Odessa", createJourney("Kiev", "Odessa"));
        storage.put("Lviv->Kiev", createJourney("Lviv", "Kiev"));
    }

    private List<Journey> createJourney(String from, String to) {
        return Arrays.asList(
                new Journey(from, to, LocalDate.now(), LocalDate.now().plusDays(1)),
                new Journey(from, to, LocalDate.now().plusDays(1), LocalDate.now().plusDays(2)),
                new Journey(from, to, LocalDate.now().plusDays(2), LocalDate.now().plusDays(3))
        );
    }

    @Override
    public Collection<Journey> find(String stationFrom, String stationTo, LocalDate dateFrom, LocalDate dateTo) {
        if (storage == null || storage.isEmpty()) return Collections.emptyList();
        List<Journey> journeys = storage.get(stationFrom + "->" + stationTo);
        if (journeys == null || journeys.isEmpty()) return Collections.emptyList();
        List<Journey> out = new ArrayList<>();
        for (Journey item : journeys) {
            if (item.getDeparture().equals(dateFrom) && item.getArrival().equals(dateTo)) {
                out.add(item);
            }
        }
        return Collections.unmodifiableList(out);
    }

    @Override
    public int createJourney(Journey entity) {
        return 0;
    }
}
