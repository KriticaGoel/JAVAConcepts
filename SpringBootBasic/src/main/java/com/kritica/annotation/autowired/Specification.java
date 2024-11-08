package com.kritica.annotation.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("spec")
public class Specification {
    @Value("Toyata")
    private String make;
    @Value("ABC")
    private String model;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Specification [make=" + make + ", model=" + model + "]";
    }


}
