package com.kritica.firstBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContextFirstBean.xml");

        MyFirstBean myBean = (MyFirstBean) context.getBean("myBean");
        System.out.println(myBean);
    }

}
