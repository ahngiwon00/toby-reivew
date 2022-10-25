package com.domain;

import com.dao.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoFactory.class)
class UserDaoTest {
    UserDao userDao;
    User user1;
    User user2;
    User user3;


    @BeforeEach
    void setUp() {
        userDao = context.getBean("awsuserDao", UserDao.class);
        user1 = new User("444", "Ahn", "1234");
        user2 = new User("555", "So", "4567");
        user3 = new User("666", "Min", "890");
    }

    @Autowired
    ApplicationContext context;

    @Test
    void addAndGet(){

        userDao.deleteAll();
        Assertions.assertEquals(0,userDao.GetCount());
        userDao.add(user1);
        Assertions.assertEquals(1,userDao.GetCount());
        User user=userDao.findById("4234");
        Assertions.assertEquals("Ahn",user.getName());

    }



}