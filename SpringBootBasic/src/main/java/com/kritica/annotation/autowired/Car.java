package com.kritica.annotation.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
    //autowired by fields
    @Autowired
    @Qualifier("spec")
    private Specification specification;
//Autowired by constructir
//    @Autowired
//   public Car(Specification specification) {
//       this.specification = specification;
//   }

    public void display() {
        System.out.println(specification.toString());
    }
}
