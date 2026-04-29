package com.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private Service service;

    public TestController() {
        System.out.println("TestController initialized");
    }

    @GetMapping("/test")
    public String test() {
        return "Up and Running";
    }

    @GetMapping("/rawjdbc")
    public void testRawJDBC() {

    }
}
