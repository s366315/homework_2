package org.hillel.homework_1.persistence.repository;

import org.hillel.homework_1.persistence.entity.JourneyEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JourneyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String REQUEST_SELECT_ALL = "SELECT * FROM homework_1;";

    @Transactional
    public int create(final JourneyEntity journeyEntity) {
        entityManager.persist(journeyEntity);
        return journeyEntity.getId();
    }

    public List<JourneyEntity> getJourneys() {
        List<JourneyEntity> out = entityManager.createNativeQuery(REQUEST_SELECT_ALL, JourneyEntity.class).getResultList();
        System.out.println();
        return out;
    }
}
