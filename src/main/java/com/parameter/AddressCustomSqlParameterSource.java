package com.parameter;


import com.Model.Address;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class AddressCustomSqlParameterSource extends MapSqlParameterSource {

    public AddressCustomSqlParameterSource(Address address) {
        addValue("city", address.getCity());
        addValue("country", address.getCountry());
    }
}
