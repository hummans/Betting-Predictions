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

        /*
        Bet b = session.get(Bet.class, 1);
        System.out.println(b.getDescription());
        */


        /*
        List<UserBet> betsByUser = session.createQuery("From UserBet ").list();

        for (UserBet ub : betsByUser) {

            if (ub.getUser().getUsername().equals("ivan123")) {
                System.out.print(ub.getUser().getUsername() + " betted on " + ub.getBet().getDescription() + ", on " + ub.getDate() +" for outcome: ");
                if (ub.getBet().getOutcomeA().equals(ub.getOutcome())) {
                    System.out.println(ub.getBet().getOutcomeA());
                } else {
                    System.out.println(ub.getBet().getOutcomeB());
                }
            }
        }
        */

    /*
        List<User> allUsers = session.createQuery("From User").list();

        for (User user : allUsers) {
            System.out.println(user.getUsername() + " betted " + user.getUserBets());
        }
        */

        Prediction p = session.get(Prediction.class, 5);
        System.out.println(p.getContent() + " " + p.getUser().getUsername());

        session.getTransaction().commit();
        session.close();

    }
}
