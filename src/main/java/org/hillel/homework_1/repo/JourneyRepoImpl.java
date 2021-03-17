package org.hillel.homework_1.repo;

import org.hillel.homework_1.Journey;
import org.springframework.beans.factory.DisposableBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JourneyRepoImpl implements JourneyRepo, DisposableBean {

    private final Connection connection;
    private final PreparedStatement statement;

    private static final String REQUEST_SELECT_ALL = "SELECT * FROM homework_1;";
    private static final String REQUEST_DELETE = "";
    private static final String REQUEST_GET_BY_ID = "SELECT * FROM homework_1 WHERE id=;";

    @Override
    public void destroy() throws Exception {
        statement.close();
        connection.close();
    }

    public JourneyRepoImpl() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1qaz2wsx");
        statement = connection.prepareStatement(REQUEST_SELECT_ALL);
    }

    @Override
    public List<Journey> getJourneys() throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Journey> journeys = new ArrayList<>();
        while (resultSet.next()) {
            Journey journey = new Journey(
                    resultSet.getString("station_from"),
                    resultSet.getString("station_to"),
                    resultSet.getDate("date_from").toLocalDate(),
                    resultSet.getDate("date_to").toLocalDate()
            );

            journeys.add(journey);
        }
        return journeys;
    }

    @Override
    public Journey getJourney(int id) throws SQLException {

        return null;
    }

    @Override
    public boolean deleteJourney(Journey journey) {
        return false;
    }

    @Override
    public boolean saveJourney(Journey journey) {
        return false;
    }
}
