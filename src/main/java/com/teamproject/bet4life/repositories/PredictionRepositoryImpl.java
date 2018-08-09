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

    private SessionFactory factory;

    public PredictionRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public List<Prediction> getAll() {
        List<Prediction> predictions = new ArrayList<>();

        try(Session session = factory.openSession()) {
            session.beginTransaction();

            predictions = session.createQuery("From Prediction").list();

            session.getTransaction().commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return predictions;
    }

    @Override
    public List<Prediction> getLatest5() {
        return getAll().stream()
                .sorted((a,b) -> b.getDate().compareTo(a.getDate()))
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public boolean savePrediction(Prediction prediction) {
        try (Session s = factory.openSession()) {
            s.beginTransaction();

            s.save(prediction);

            s.getTransaction().commit();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
