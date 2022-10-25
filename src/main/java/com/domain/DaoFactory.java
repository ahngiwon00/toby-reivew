package com.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao awsuserDao(){
        UserDao userDao = new UserDao(new awsConnectionMaker());
        return userDao;
    }
}
