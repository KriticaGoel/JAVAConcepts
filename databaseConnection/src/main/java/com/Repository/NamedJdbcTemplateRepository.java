package com.Repository;

import com.Model.Users;
import com.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class NamedJdbcTemplateRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //create using Map
    public int createUserMap(UserRequest user) {
        String sql = "insert into users(name,email) values (:name,:email)";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", user.getName());
        params.put("email", user.getEmail());

        return namedParameterJdbcTemplate.update(sql, params);

    }


    //Create using BeanPropertySqlParameterSource
    public int createUser(Users user) {
        String sql = "Insert into Users(name,email) values(:name,:email)";
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user));
    }

    // select
    //single record
    //list of records

    //Update

    /// Delete


}
