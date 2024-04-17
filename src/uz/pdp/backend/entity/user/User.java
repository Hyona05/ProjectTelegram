package uz.pdp.backend.entity.user;

import uz.pdp.backend.entity.BaseModel;
import uz.pdp.backend.enums.UserRole;
import uz.pdp.backend.enums.UserStatus;

import java.util.Date;

public class User extends BaseModel {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Integer age;
    private String phoneNumber;
    private UserRole role;
    private UserStatus status;

    public User(String firstName, String lastName, String userName, String password,
                String phoneNumber, UserRole role, UserStatus status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

}
