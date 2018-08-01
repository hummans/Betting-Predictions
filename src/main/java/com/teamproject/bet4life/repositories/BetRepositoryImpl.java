package com.teamproject.bet4life.repositories;

import com.teamproject.bet4life.models.Bet;
import com.teamproject.bet4life.repositories.base.BetRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class BetRepositoryImpl implements BetRepository {

    private SessionFactory sessionFactory;

    public BetRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Bet> getAll() {
        List<Bet> bets = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            bets = session.createQuery("From Bet").list();

            session.getTransaction().commit();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        return bets;
    }
}
