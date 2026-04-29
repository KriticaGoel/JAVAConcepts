package com.Service;

import com.Repository.RawJDBCConnection;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class TestService {

    private RawJDBCConnection rawJDBCConnection;

    public TestService(RawJDBCConnection rawJDBCConnection) {
        this.rawJDBCConnection = rawJDBCConnection;
    }

    public void testRawJDBC() throws SQLException {
        rawJDBCConnection.getUsers();
        rawJDBCConnection.insertUser("John Doe", "kksdas@gmail.com");
        rawJDBCConnection.updateUsers("Kritica", "abc@gmail.com");
        rawJDBCConnection.getUsers();
    }
}
