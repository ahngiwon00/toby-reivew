package com.domain;

import com.dao.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void addAndGet(){
        UserDao userDao = new DaoFactory().awsuserDao();
        userDao.add(new User("12333", "dsa", "12345678"));
        User user=userDao.findById("12333");
        Assertions.assertEquals("dsa",user.getName());

    }

}