package com.Controller;

import com.Service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class TestController {

    private TestService service;

    public TestController(TestService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String test() {
        return "Up and Running";
    }

    @GetMapping("/rawjdbc")
    public void testRawJDBC() throws SQLException {
        service.testRawJDBC();

    }
}
