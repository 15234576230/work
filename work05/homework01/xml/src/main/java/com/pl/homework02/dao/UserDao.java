package com.pl.homework02.dao;

import com.pl.homework02.model.User;

public class UserDao {

    public User selectOne(){
        return new User("小明",16);
    }
}
