package com.Repository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RawJDBCConnection {

    @Autowired
    private DataSource dataSource;

    public void connect() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //load drivers
            connection = dataSource.getConnection();

            //Create a query
            String sql = "SELECT * FROM users";
            preparedStatement = connection.prepareStatement(sql);
            //Execute Query
            resultSet = preparedStatement.executeQuery();
            //Mapping result
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Email: " + resultSet.getString("email"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }


    }
}
