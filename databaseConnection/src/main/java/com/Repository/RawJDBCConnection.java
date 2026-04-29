package com.Repository;

import com.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RawJDBCConnection {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Users users;

    public void getUsers() throws SQLException {
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
                users.setId(resultSet.getInt("id"));
                users.setName(resultSet.getString("name"));
                users.setEmail(resultSet.getString("email"));

                System.out.println("User ID: " + users.getId());
                System.out.println("Username: " + users.getName());
                System.out.println("Email: " + users.getEmail());

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void insertUser(String name, String email) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //load drivers
            connection = dataSource.getConnection();

            String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows inserted: " + rowsAffected);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }
    }

    public void updateUsers(String name, String email) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //load drivers
            connection = dataSource.getConnection();

            String sql = "Update users set email=? where name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, name);
            preparedStatement.setString(1, email);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows updated: " + rowsAffected);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }
    }


}
