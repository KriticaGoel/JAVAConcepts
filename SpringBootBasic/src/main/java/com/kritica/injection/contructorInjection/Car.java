package com.kritica.injection.contructorInjection;

public class Car {
    private Specification specification;

    public Car(Specification specification) {
        this.specification = specification;
    }

    public void display() {
        System.out.println(specification.toString());
    }
}
