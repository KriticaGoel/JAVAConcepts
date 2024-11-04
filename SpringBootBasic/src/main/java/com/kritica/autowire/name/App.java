package com.kritica.autowire.name;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContextAutoWireByName.xml");

        Car car = (Car) context.getBean("car");
        car.display();

    }
}
