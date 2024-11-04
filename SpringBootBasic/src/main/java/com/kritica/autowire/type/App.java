package com.kritica.autowire.type;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContextAutoWireByType.xml");

        Car car = (Car) context.getBean("car");
        car.display();

    }
}
