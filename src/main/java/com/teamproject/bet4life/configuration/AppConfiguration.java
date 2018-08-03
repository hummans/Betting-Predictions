package com.teamproject.bet4life.configuration;

import com.teamproject.bet4life.entities.Bet;
import com.teamproject.bet4life.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public SessionFactory createSessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Bet.class)
                .buildSessionFactory();
    }


}
