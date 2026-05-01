package com.Service;

import com.Model.Users;
import com.Repository.RawJDBCConnection;
import com.Repository.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TestService {

    private RawJDBCConnection rawJDBCConnection;
    private UserJdbcRepository userJdbcRepository;

    public TestService(RawJDBCConnection rawJDBCConnection, UserJdbcRepository userJdbcRepository) {
        this.rawJDBCConnection = rawJDBCConnection;
        this.userJdbcRepository = userJdbcRepository;
    }

    public void testRawJDBC() throws SQLException {
        rawJDBCConnection.getUsers();
        rawJDBCConnection.insertUser("John Doe", "kksdas@gmail.com");
        rawJDBCConnection.updateUsers("Kritica", "abc@gmail.com");
        rawJDBCConnection.getUsers();
    }

    public Users testJDBCTemplateGetUser(String id) {
        return userJdbcRepository.findById(id);
    }

    public Users testJDBCTemplateGetUserByName(String name) {
        return userJdbcRepository.findByName(name);
    }

    public List<Users> testJDBCTemplateGetUsers() {
        return userJdbcRepository.findAll();

    }

    public int deleteUser(String name) {
        return userJdbcRepository.deleteByName(name);
    }

    public int updateByName(String name, String email) {
        return userJdbcRepository.updateByName(name, email);
    }

    public int createuser(String name, String email) {
        return userJdbcRepository.createUser(name, email);
    }


}
