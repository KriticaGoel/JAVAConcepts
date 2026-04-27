package CoreJava.Generics.Inheritence;

import java.util.List;

public class Users {

    private String name;
    private Integer phoneNumber;

    public Users() {

    }

    public Users(String name, Integer phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void login() {
        System.out.printf("User %s logged in %n", this.name);
    }

    public void logout() {
        System.out.printf("User %s logged out %n", this.name);
    }

    public <E extends Users> void printUsers(List<E> users) {
        users.forEach(user -> {
            System.out.println(user.getName());
            user.login();
        });
    }

    public void printUser(Users user) {
        System.out.println(user.getName());
        user.login();
    }
}
