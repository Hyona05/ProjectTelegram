package uz.pdp.backend.service.userservice;

import uz.pdp.backend.dto.LoginDTO;
import uz.pdp.backend.dto.SignUpDTO;
import uz.pdp.backend.entity.user.User;


import java.util.ArrayList;
import java.util.List;

public class UserServiceImplementation implements UserService{
    private List<User> list;

    private UserServiceImplementation() {
        this.list = new ArrayList<>();
    }
    @Override
    public void create(User entity) {
        list.add(entity);
    }

    @Override
    public User get(String id) {
        return null;
    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public void update(User newEntity) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User login(LoginDTO login) {
        return null;
    }

    @Override
    public void signUp(SignUpDTO signUp) {

    }
    private static UserServiceImplementation userServiceImpl;
    public static UserServiceImplementation getInstance(){
        if (userServiceImpl==null) {
            userServiceImpl = new UserServiceImplementation();
        }
        return userServiceImpl;
    }

}
