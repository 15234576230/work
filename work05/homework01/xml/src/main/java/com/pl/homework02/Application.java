package com.pl.homework02;

import com.pl.homework02.factory.BeanFactory;
import com.pl.homework02.service.UserService;

public class Application {

    public static UserService userService = (UserService) BeanFactory.getObject("userService");

    public static void main(String[] args) {
        System.out.println(userService.getUser());
//        System.out.println();
    }


}
