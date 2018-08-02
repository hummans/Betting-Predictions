package com.teamproject.bet4life.repositories;

import com.teamproject.bet4life.models.Prediction;
import com.teamproject.bet4life.repositories.base.PredictionRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PredictionRepositoryImpl implements PredictionRepository {
    private SessionFactory sessionFactory;

    public PredictionRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Prediction> getAll() {
        List<Prediction> predictions = new ArrayList<>();

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            predictions = session.createQuery("From Prediction").list();

            session.getTransaction().commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return predictions;
    }

    @Override
    public List<Prediction> getLatest3Predictions() {
        return getAll().stream()
                .sorted((a,b) -> b.getDatePublished().compareTo(a.getDatePublished()))
                .limit(3)
                .collect(Collectors.toList());
    }
}
