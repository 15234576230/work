package com.pl;

import com.pl.factory.AnnotationBeanFactory;
import com.pl.factory.BeanFactory;
import com.pl.service.AccountService;

public class StartApplication {

    public static void main(String[] args) throws ClassNotFoundException {
        BeanFactory beanFactory = new AnnotationBeanFactory();
        AccountService accountService = (AccountService) beanFactory.getBeans("accountService");
        accountService.transfer("jack","rose",1000);
    }



}
