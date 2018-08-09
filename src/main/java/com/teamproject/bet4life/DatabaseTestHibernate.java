package com.teamproject.bet4life;

import com.teamproject.bet4life.models.Bet;
import com.teamproject.bet4life.models.Prediction;
import com.teamproject.bet4life.models.Role;
import com.teamproject.bet4life.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
public class DatabaseTestHibernate {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Bet.class)
                .addAnnotatedClass(Prediction.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        List<Bet> bets = session.createQuery("From Bet").list();

        for (Bet b : bets) {
            System.out.println(b.getDescription());
        }

        session.getTransaction().commit();
        session.close();


    }
}
