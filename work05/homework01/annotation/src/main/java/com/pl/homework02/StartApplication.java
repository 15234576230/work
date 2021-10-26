package com.pl.homework02;

import com.pl.homework02.factory.AnnotationBeanFactory;
import com.pl.homework02.factory.BeanFactory;
import com.pl.homework02.service.AccountService;

public class StartApplication {

    public static void main(String[] args) throws ClassNotFoundException {
        BeanFactory beanFactory = new AnnotationBeanFactory();
        AccountService accountService = (AccountService) beanFactory.getBeans("accountService");
        accountService.transfer("jack","rose",1000);
    }



}
