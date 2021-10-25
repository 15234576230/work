package com.pl;

import com.pl.factory.BeanFactory;
import com.pl.service.UserService;

public class Application {

    public static UserService userService = (UserService) BeanFactory.getObject("userService");

    public static void main(String[] args) {
        System.out.println(userService.getUser());
//        System.out.println();
    }


}
