package com.teamproject.bet4life.repositories;

import com.teamproject.bet4life.models.Prediction;
import com.teamproject.bet4life.repositories.base.PredictionRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PredictionRepositoryImpl implements PredictionRepository {

    private SessionFactory factory;

    public PredictionRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
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
