package com.kritica.autowire.name;

public class Car {
    private Specification carSpecification;

    //Autowire by name use setter method to set values
    public void setCarSpecification(Specification carSpecification) {
        this.carSpecification = carSpecification;
    }

    public void display() {
        System.out.println(carSpecification.toString());
    }
}
