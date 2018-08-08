package com.teamproject.bet4life;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bet4lifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Bet4lifeApplication.class, args);
     }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
