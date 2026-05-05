package com.parameter;


import com.Model.Users;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class UserCustomSqlParameterSource extends MapSqlParameterSource {

    public UserCustomSqlParameterSource(Users user) {
        addValue("name", user.getName());
        addValue("email", user.getEmail());
    }
}
