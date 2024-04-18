package uz.pdp.backend.service.userservice;

import uz.pdp.backend.dto.LoginDTO;
import uz.pdp.backend.dto.SignUpDTO;
import uz.pdp.backend.entity.user.User;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        for (User user : list) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getList() {
        return list;
    }

    @Override
    public void update(User newEntity) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getId().equals(newEntity.getId())) {
                list.set(i, newEntity);
                System.out.println("User updated");
                return;
            }
        }
        System.out.println("User not found");
    }


    @Override
    public void delete(String id) {
      for (User user: list) {
          if (user.getId().equals(id)) {
              list.remove(user);
          }
      }
        System.out.println("User deleted: " + id);
    }

    @Override
    public User login(LoginDTO login){
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
