package com.parameter;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class UserAddressCustomSqlParameterSource extends MapSqlParameterSource {

    public UserAddressCustomSqlParameterSource(Integer userId, Integer addressId) {

        addValue("userId", userId);
        addValue("addressId", addressId);
    }
}
