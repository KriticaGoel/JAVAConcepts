package com.Repository;

import com.Model.Address;
import com.Model.Users;
import com.dto.UserDTO;
import com.parameter.AddressCustomSqlParameterSource;
import com.parameter.UserAddressCustomSqlParameterSource;
import com.parameter.UserCustomSqlParameterSource;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NamedJdbcTemplateRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //create using Map
    public int createUserMap(UserDTO user) {
        String sql = "insert into users(name,email) values (:name,:email)";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", user.getName());
        params.put("email", user.getEmail());

        return namedParameterJdbcTemplate.update(sql, params);

    }


    //Create using BeanPropertySqlParameterSource ->

    // BeanPropertySqlParameterSource -> Its map Java field → SQL named parameter
    public int createUserUsingBeanPropSqlParSource(UserDTO user) {
        String sql = "Insert into Users(name,email) values(:name,:email)";
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user));
    }

    //Create using Custom ParameterSource

    public int createUserUsingMapSqlParameterSource(Users user) {

        //get user id
        KeyHolder userKey = new GeneratedKeyHolder();
        //insert user
        String userSql = "Insert into users (name,email) values (:name,:email)";
        namedParameterJdbcTemplate.update(userSql, new UserCustomSqlParameterSource(user), userKey, new String[]{"id"});

        //userKey contain user id to export the value in a variable
        Integer userId = userKey.getKey().intValue();

        return userId;
    }

    //Read Single row
    public Users getUserByName(String name) {

        String sql = "select * frm users where name =:name";
        //Object[] params = new Object[]{name};  -- wrong
        Map<String, Object> params = Map.of("name", name);
//        Map<String,Object> params= new HashMap();
//        params.put("name", name);
        RowMapper<Users> rowMapper = (rs, rowNum) -> {
            Users user = new Users();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        };

        return namedParameterJdbcTemplate.queryForObject(sql, params, rowMapper);
    }


    //Read Multiple row
    public List<Users> getUsers() {
        String sql = "select * from Users";
        RowMapper<Users> rowMapper = (rs, rowNum) -> {
            Users user = new Users();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        };

        return namedParameterJdbcTemplate.query(sql, rowMapper);
    }

    //Update single record
    public int updateUserByName(UserDTO user) {
        String sql = "Update Users set email=:email where name=:name";
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user));
    }

    //Delete row
    public int deleteUser(String name) {
        String sql = "Delete from users where name =:name";
        Map<String, Object> params = Map.of("name", name);
        return namedParameterJdbcTemplate.update(sql, params);
    }

//NESTED

    //Create User and Address M:M

    @Transactional
    public int createUserAddressUsingMapSqlParameterSource(Users user) {

        //get user id
        KeyHolder userKey = new GeneratedKeyHolder();
        //insert user
        String userSql = "Insert into users (name,email) values (:name,:email)";
        namedParameterJdbcTemplate.update(userSql, new UserCustomSqlParameterSource(user), userKey, new String[]{"id"});

        //userKey contain user id to export the value in a variable
        Integer userId = userKey.getKey().intValue();

        //Insert Address
        for (Address address : user.getAddress()) {

            KeyHolder addressKey = new GeneratedKeyHolder();
            String addressSql = "insert into address (city,country) values(:city,:country)";
            namedParameterJdbcTemplate.update(addressSql, new AddressCustomSqlParameterSource(address), addressKey, new String[]{"address_id"});

            //address key contain address id
            Integer addressId = addressKey.getKey().intValue();

            //insert into mapping table
            String userAddressMappingSql = "insert into useraddress (user_id,address_id) values(:userId,:addressId)";
            namedParameterJdbcTemplate.update(userAddressMappingSql, new UserAddressCustomSqlParameterSource(userId, addressId));

        }
        return userId;
    }
    // Read - JOIN + ResultSetExtractor

    public Users getUsersWithAddress() {
        return null;
    }

    //UPDATE - Delete + Reinsert mapping

    //DELETE - both granular (single address) & full user


    //Create user order 1:M

    //Create using Flatten DTO (avoid nested Classes)


    //Dynamic Query (Very Powerful)


}
