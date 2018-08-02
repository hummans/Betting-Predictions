package com.teamproject.bet4life.config;

import com.teamproject.bet4life.models.Bet;
import com.teamproject.bet4life.models.Prediction;
import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.models.UserBet;
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
                .addAnnotatedClass(UserBet.class)
                .addAnnotatedClass(Prediction.class)
                .buildSessionFactory();
    }
}
