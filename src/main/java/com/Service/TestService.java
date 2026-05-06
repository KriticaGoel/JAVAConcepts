package com.Service;

import com.Model.Address;
import com.Model.Users;
import com.Repository.NamedJdbcTemplateRepository;
import com.Repository.RawJDBCConnection;
import com.Repository.UserJdbcRepository;
import com.dto.AddressDTO;
import com.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    private RawJDBCConnection rawJDBCConnection;
    private UserJdbcRepository userJdbcRepository;
    private NamedJdbcTemplateRepository namedJdbcTemplateRepository;

    public TestService(RawJDBCConnection rawJDBCConnection, UserJdbcRepository userJdbcRepository, NamedJdbcTemplateRepository namedJdbcTemplateRepository) {
        this.rawJDBCConnection = rawJDBCConnection;
        this.userJdbcRepository = userJdbcRepository;
        this.namedJdbcTemplateRepository = namedJdbcTemplateRepository;
    }

    public void testRawJDBC() throws SQLException {
        rawJDBCConnection.getUsers();
        rawJDBCConnection.insertUser("John Doe", "kksdas@gmail.com");
        rawJDBCConnection.updateUsers("Kritica", "abc@gmail.com");
        rawJDBCConnection.getUsers();
    }

    public Users testJDBCTemplateGetUser(String id) {
        return userJdbcRepository.findById(id);
    }

    public Users testJDBCTemplateGetUserByName(String name) {

        //return userJdbcRepository.findByName(name);
        return namedJdbcTemplateRepository.getUserByName(name);

    }

    public List<Users> testJDBCTemplateGetUsers() {
        //return userJdbcRepository.findAll();
        return namedJdbcTemplateRepository.getUsers();

    }

    public int deleteUser(String name) {

        //return userJdbcRepository.deleteByName(name);
        return namedJdbcTemplateRepository.deleteUser(name);
    }

    public int updateByName(String name, String email) {

        //return userJdbcRepository.updateByName(name, email);
        UserDTO user = new UserDTO(name, email);
        return namedJdbcTemplateRepository.updateUserByName(user);
    }

    public int createUser(String name, String email) {
        //  return userJdbcRepository.createUser(name, email);
        Users user = new Users();
        user.setName(name);
        user.setEmail(email);
        // request.setAddress(address);

        //return namedJdbcTemplateRepository.createUserMap(request);
        // return namedJdbcTemplateRepository.createUserUsingBeanPropSqlParSource(request);
        return namedJdbcTemplateRepository.createUserUsingMapSqlParameterSource(user);
    }

    //Flatten Manually
    public int createUserAddressUsingMapSqlParameterSource(UserDTO userDto) {
        Users user = new Users();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

        List<Address> addList = new ArrayList<Address>();
        for (AddressDTO address : userDto.getAddress()) {
            Address add = new Address();
            add.setCity(address.getCity());
            add.setCountry(address.getCountry());
            addList.add(add);
        }

        user.setAddress(addList);

        return namedJdbcTemplateRepository.createUserAddressUsingMapSqlParameterSource(user);
    }

    public List<Users> getUserAndAddress(Integer userId) {
        return namedJdbcTemplateRepository.getUsersWithAddress(userId);
    }


}
