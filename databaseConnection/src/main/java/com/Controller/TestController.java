package com.Controller;

import com.Model.Users;
import com.Service.TestService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

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

    @GetMapping("/jdbcTemplate/getUsersById/{id}")
    public Users testJDBCTemplateGetUser(@PathVariable String id) throws SQLException {
        return service.testJDBCTemplateGetUser(id);

    }

    @GetMapping("/jdbcTemplate/getUsersByName/{name}")
    public Users testJDBCTemplateGetUserByName(@PathVariable String name) throws SQLException {
        return service.testJDBCTemplateGetUserByName(name);

    }

    @GetMapping("/jdbcTemplate/getUsers/")
    public List<Users> testJDBCTemplateGetUsers() throws SQLException {
        return service.testJDBCTemplateGetUsers();

    }

    @PostMapping("/jdbcTemplate/createUser/{name}/{email}")
    public int createUser(@PathVariable String name, @PathVariable String email) throws SQLException {
        return service.createUser(name, email);

    }

    @PostMapping("/jdbcTemplate/updateUser/{name}/{email}")
    public int updateUser(@PathVariable String name, @PathVariable String email) throws SQLException {
        return service.updateByName(name, email);
    }

    @DeleteMapping("/jdbcTemplate/deleteUser/{name}")
    public int deleteUser(@PathVariable String name) throws SQLException {
        return service.deleteUser(name);
    }

}
