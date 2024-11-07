package com.kritica.activemqexample;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MeesageConsumerService {

    @JmsListener(destination = "myQueue")
    public void listenMessge(String name) {
        System.out.println("Listening Messge " + name);
    }

}
