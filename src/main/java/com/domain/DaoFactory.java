package com.domain;

public class DaoFactory {
    public UserDao awsuserDao(){
        UserDao userDao = new UserDao(new awsConnectionMaker());
        return userDao;
    }
}
