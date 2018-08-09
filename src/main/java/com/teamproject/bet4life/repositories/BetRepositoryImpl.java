package com.teamproject.bet4life.repositories;

import com.teamproject.bet4life.models.Bet;
import com.teamproject.bet4life.models.Prediction;
import com.teamproject.bet4life.repositories.base.BetRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BetRepositoryImpl implements BetRepository {

    private SessionFactory factory;

    public BetRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Bet> getAll() {
        List<Bet> bets = new ArrayList<>();

        try (Session session = factory.openSession()){

            session.beginTransaction();
            Query query = session.createQuery("FROM Bet");
            bets = query.list();
            session.getTransaction().commit();

        }catch(Exception e){
            System.out.print(e.getMessage());
            e.printStackTrace();
        }

        if (bets != null) {
            Collections.sort(bets, new Comparator<Bet>() {
                @Override
                public int compare(Bet o1, Bet o2) {
                    return o2.getDate().compareTo(o1.getDate());
                }
            });
        }

        return bets;
    }

    @Override
    public List<Bet> getLatest5() {
        return getAll().stream()
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public Bet findByDescription(String description) {
        Bet bet = null;

        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("from Bet where description=:desc");
            query.setParameter("desc",description);
            bet = (Bet)query.uniqueResult();

            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }

        return bet;
    }
}
