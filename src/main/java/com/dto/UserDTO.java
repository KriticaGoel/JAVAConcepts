package com.dto;

import java.util.List;

public class UserDTO {

    private String name;
    private String email;
    private List<AddressDTO> address;

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public List<AddressDTO> getAddress() {
        return address;
    }

    public void setAddress(List<AddressDTO> address) {
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
