package com.teamproject.bet4life;

import com.teamproject.bet4life.models.Bet;
import com.teamproject.bet4life.models.Prediction;
import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.models.UserBet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class DatabaseTestHibernate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Bet.class)
                .addAnnotatedClass(UserBet.class)
                .addAnnotatedClass(Prediction.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();

       Prediction p = new Prediction();
       p.setContent("This is a test prediction");
       p.setDatePublished(new Date());
       p.setUser(session.get(User.class,3));
       p.setBet(session.get(Bet.class,5));
       session.save(p);
        session.getTransaction().commit();
        session.close();

    }
}
