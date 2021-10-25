package com.pl.service;

import com.pl.dao.UserDao;
import com.pl.model.User;

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
