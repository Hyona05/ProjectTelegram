package uz.pdp.backend.entity.user;

import uz.pdp.backend.entity.BaseModel;
import uz.pdp.backend.enums.UserStatus;

public class User extends BaseModel {

    private String fullName;
    private String userName;
    private String password;
    private UserStatus status;

    public User(String fullName, String userName, String password) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
    }
    public User(String fullName, String userName, String password, UserStatus status) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

}
