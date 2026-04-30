package com.Repository;

import com.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJdbcRepository {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public Users findById(String id) {

        String sql = "SELECT * FROM users WHERE id = ?";

        Object[] params = new Object[]{id};

        RowMapper<Users> rowMapper = (rs, rowNum) -> {
            Users u = new Users();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setEmail(rs.getString("email"));
            return u;
        };

        return jdbcTemplate.queryForObject(sql, params, rowMapper);

    }

    public Users findByName(String name) {

        String sql = "select * from users where ucase(name) = ?";
        Object[] params = new Object[]{name.toUpperCase()};

        RowMapper<Users> rowmapper = (rs, rowNum) -> {
            Users u = new Users();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setEmail(rs.getString("email"));
            return u;
        };

        return jdbcTemplate.queryForObject(sql, params, rowmapper);
    }

    public Users findByEmail(String email) {

        String sql = "select * from users where emiail=?";

        Object[] params = new Object[]{email.toUpperCase()};

        RowMapper<Users> rowMapper = (rs, rowNum) -> {
            Users u = new Users();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setEmail(rs.getString("email"));
            return u;
        };

        return jdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    public List<Users> findAll() {
        String sql = "Select * from Users";

        RowMapper<Users> rowMapper = (rs, rowNum) -> {
            Users u = new Users();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setEmail(rs.getString("email"));
            return u;
        };

        return jdbcTemplate.query(sql, new Object[]{}, rowMapper);
    }

    public int createUser(String name, String email) {
        String sql = "insert into users(name,email) values(?,?)";
        return jdbcTemplate.update(sql, name, email);
    }

    public int updateByName(String name, String email) {
        String sql = "update Users set email=? where ucase(name)=?";
        return jdbcTemplate.update(sql, email, name.toUpperCase());
    }

    public int deleteByName(String name) {
        String sql = "Delete fromUsers where ucase(name)=?";
        return jdbcTemplate.update(sql, name.toUpperCase());

    }
}
