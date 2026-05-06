package com.Repository;

import com.Model.Address;
import com.Model.Users;
import com.dto.UserDTO;
import com.mapper.UsersResultSetExtractor;
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
    // Read - JOIN + ResultSetExtrac4tor

    public List<Users> getUsersWithAddress(Integer userId) {
        String sql = "select u.id,u.name,u.email,a.address_id,a.city,a.country from users u " +
                "left join useraddress ua on ua.user_id=u.id " +
                "left join address a on a.address_id=ua.address_id where u.id=:userId";
        Map<String, Object> params = Map.of("userId", userId);

        return namedParameterJdbcTemplate.query(sql, params, new UsersResultSetExtractor());
    }

    //UPDATE - Delete + Reinsert mapping
    //Update user and all address - getting complete uer object again
    // update user attributes
    // update address attributes
    @Transactional
    public int updateUserComplete(Users users) {
        //  Update user attributes
        String userSql = "update users set name=:name,email =:email where id=:userId";
        int rowAffected = namedParameterJdbcTemplate.update(userSql, new UserCustomSqlParameterSource(users).addValue("userId", users.getId()));

        if (rowAffected == 0) {
            System.out.println("user not found");
        } else {
            if (users.getAddress() != null && !users.getAddress().isEmpty()) {
                //Update existing address attributes
                for (Address address : users.getAddress()) {
                    if (address.getAddressId() != null) {
                        String addressSql = "update address set city=:city , country=:country where address_id=:addressId";
                        namedParameterJdbcTemplate.update(addressSql, new AddressCustomSqlParameterSource(address).addValue("addressId", address.getAddressId()));
                    } else {
                        //Insert new addresses (if needed)
                        KeyHolder addressKey = new GeneratedKeyHolder();
                        String addressSql = "Insert into address (city,country) values(:city,:country)";
                        namedParameterJdbcTemplate.update(addressSql, new AddressCustomSqlParameterSource(address), addressKey, new String[]{"address_id"});

                        int addressId = addressKey.getKey().intValue();
                        address.setAddressId(addressId);
                    }
                }
                //Delete old mappings
                String mappingDelete = "delete from useraddress where user_id=:userId";
                namedParameterJdbcTemplate.update(mappingDelete, Map.of("userId", users.getId()));


                //Insert mappings
                for (Address address : users.getAddress()) {
                    String mappingInsert = "insert into useraddress (user_id,address_id) values(:userId,:addressId)";
                    namedParameterJdbcTemplate.update(mappingInsert, new UserAddressCustomSqlParameterSource(users.getId(), address.getAddressId()));
                }
            }
        }
        return 0;
    }
    //DELETE - both granular (single address) & full user

    //Case 1 Delete one address
    @Transactional
    public int deleteAddress(int addressId) {
        String sql = "Delete from useraddress where address_id=:addressId";
        namedParameterJdbcTemplate.update(sql, Map.of("addressId", addressId));

        String addressSql = "Delete from address where address_id=:addressId";
        return namedParameterJdbcTemplate.update(addressSql, Map.of("addressId", addressId));
    }

    //case 2: Delete all address
    @Transactional
    public int deleteAllAddress(int userId) {
        String mappingSql = "select address_id from useraddress where user_id=:userId";
        List<Integer> addressIds = namedParameterJdbcTemplate.queryForList(mappingSql, Map.of("userId", userId), Integer.class);

        String sql = "Delete from useraddress where user_id=:userId";
        namedParameterJdbcTemplate.update(sql, Map.of("userId", userId));

        for (Integer addressId : addressIds) {
            String addressSql = "Delete from address where address_id=:addressId";
            namedParameterJdbcTemplate.update(addressSql, Map.of("addressId", addressId));
        }
        return addressIds.size();
    }

    //case 3: Delete Users
    @Transactional
    public int deleteUser(int userId) {
        String mappingSql = "select address_id from useraddress where user_id=:userId";
        List<Integer> addressIds = namedParameterJdbcTemplate.queryForList(mappingSql, Map.of("userId", userId), Integer.class);

        String sql = "Delete from useraddress where user_id=:userId";
        namedParameterJdbcTemplate.update(sql, Map.of("userId", userId));

        for (Integer addressId : addressIds) {
            String addressSql = "Delete from address where address_id=:addressId";
            namedParameterJdbcTemplate.update(addressSql, Map.of("addressId", addressId));
        }

        String userSql = "Delete from users where user_id=:userId";
        return namedParameterJdbcTemplate.update(sql, Map.of("userId", userId));

    }

    //Dynamic Query (Very Powerful)


}
