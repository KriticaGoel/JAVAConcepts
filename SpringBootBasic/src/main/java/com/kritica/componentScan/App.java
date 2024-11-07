package com.kritica.componentScan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextComponentScan.xml");
        Employee emp = context.getBean("employees", Employee.class);
        System.out.println(emp.toString());
    }
}
