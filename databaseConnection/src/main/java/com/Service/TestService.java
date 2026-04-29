package com.Service;

import com.Repository.RawJDBCConnection;

import java.sql.SQLException;

public class TestService {

    private RawJDBCConnection rawJDBCConnection;

    public TestService(RawJDBCConnection rawJDBCConnection) {
        this.rawJDBCConnection = rawJDBCConnection;
    }

    public void testRawJDBC() throws SQLException {
        rawJDBCConnection.connect();
    }
}
