package org.hillel.homework_1.persistence.repository;

import org.hillel.homework_1.persistence.entity.JourneyEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("journeyRepository")
public class JourneyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public int create(final JourneyEntity journeyEntity) {
        entityManager.persist(journeyEntity);
        return journeyEntity.getId();
    }
}
