package com.teamproject.bet4life.repositories;

import com.teamproject.bet4life.models.UserBet;
import com.teamproject.bet4life.repositories.base.UserBetRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserBetRepositoryImpl implements UserBetRepository {
    private SessionFactory sessionFactory;

    public UserBetRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserBet> getAll() {
        List<UserBet> usersAndBets = new ArrayList<>();

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            usersAndBets = session.createQuery("From UserBet").list();
            session.getTransaction().commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return usersAndBets;
    }

    @Override
    public List<UserBet> getLatest3Bets() {
        return getAll().stream()
                .sorted((a,b) -> b.getDate().compareTo(a.getDate()))
                .limit(3)
                .collect(Collectors.toList());
    }
}
