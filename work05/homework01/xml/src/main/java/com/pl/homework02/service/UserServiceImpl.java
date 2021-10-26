package com.pl.homework02.service;

import com.pl.homework02.dao.UserDao;
import com.pl.homework02.model.User;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser() {
        return new User("小明",16);
    }
}
