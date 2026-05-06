package com.mapper;

import com.Model.Address;
import com.Model.Users;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersResultSetExtractor implements ResultSetExtractor<List<Users>> {

    @Override
    public List<Users> extractData(ResultSet rs) throws SQLException {


//        List<Users> list= new ArrayList<>();
//
//        if(rs!=null){
//             while(rs.next()){
//                 int userId=rs.getInt("id");
//                 if(!isUserPresent(userId,list)){
//                     Users user=new Users();
//                     user.setId(userId);
//                     user.setName(rs.getString("name"));
//                     user.setEmail(rs.getString("email"));
//                     user.setAddress(new ArrayList());
//                 }
//            }
//        }
        Map<Integer, Users> map = new HashMap<>();

        if (rs != null) {
            while (rs.next()) {
                int userId = rs.getInt("id");
                Users user = map.get(userId);
                if (user == null) {
                    user = new Users();
                    user.setId(userId);
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setAddress(new ArrayList<Address>());
                    map.put(userId, user);
                }
                int addressId = rs.getInt("address_id");//may be 0 that means data in db is null
                if (!rs.wasNull()) {
                    Address address = new Address();
                    address.setAddressId(addressId);
                    address.setCity(rs.getString("city"));
                    address.setCountry(rs.getString("country"));
                    user.getAddress().add(address);

                }

            }
            return new ArrayList<Users>(map.values());
        }

        return null;
    }

    private Boolean isUserPresent(int userId, List<Users> users) {
        //O(N)
        for (Users u : users) {
            if (u.getId() == userId) {
                return true;
            }
        }
        return false;
    }
}
