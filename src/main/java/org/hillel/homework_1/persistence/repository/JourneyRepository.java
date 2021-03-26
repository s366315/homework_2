package org.hillel.homework_1.persistence.repository;

import org.hillel.homework_1.persistence.entity.JourneyEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JourneyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public int create(final JourneyEntity journeyEntity) {
        entityManager.persist(journeyEntity);
        return journeyEntity.getId();
    }

    public List<JourneyEntity> getJourneys() {
       /* List<JourneyEntity> out = entityManager.createQuery("select a from homework_1").getResultList();
        System.out.println();*/
        return new ArrayList<>();
    }
}
