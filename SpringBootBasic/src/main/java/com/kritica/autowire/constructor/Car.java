package com.kritica.autowire.constructor;

public class Car {
    private Specification carSpecification;

    public Car(Specification carSpecification) {
        this.carSpecification = carSpecification;
    }

    public void display() {
        System.out.println(carSpecification.toString());
    }
}
