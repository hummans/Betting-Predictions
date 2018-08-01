package com.teamproject.bet4life;

import com.teamproject.bet4life.Models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DatabaseTestHibernate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)

                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();

        /*
        User u = session.get(User.class, 1);
        System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getBalance());
        */


       
        session.getTransaction().commit();
        session.close();

    }
}
