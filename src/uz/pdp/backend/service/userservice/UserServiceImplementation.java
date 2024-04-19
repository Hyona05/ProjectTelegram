package uz.pdp.backend.service.userservice;

import uz.pdp.backend.dto.LoginDTO;
import uz.pdp.backend.entity.user.User;
import uz.pdp.backend.enums.UserStatus;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserServiceImplementation implements UserService{
    private List<User> users;
    private static UserServiceImplementation userServiceImpl;

    public static UserServiceImplementation getInstance(){
        if (userServiceImpl==null) {
            userServiceImpl = new UserServiceImplementation();
        }
        return userServiceImpl;
    }

    private UserServiceImplementation() {
        this.users = new ArrayList<>();
        this.users.add(new User("Sanobar","Arslonboyeva","Sanobar","0909",19,"123 45 67", UserStatus.ACTIVE));
    }

    @Override
    public boolean create(User entity) {
        if (entity == null) {
            return false;
        }
        for (User existingUser : users) {
            if (existingUser.getId().equals(existingUser.getId())) {
                return false;
            }
        }
        users.add(entity);
        return true;
    }

    @Override
    public User get(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getList() {
        return users;
    }

    @Override
    public void update(User newEntity) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getId().equals(newEntity.getId())) {
                users.set(i, newEntity);
                System.out.println("User updated");
                return;
            }
        }
        System.out.println("User not found");
    }


    @Override
    public void delete(String id) {
      for (User user: users) {
          if (user.getId().equals(id)) {
              users.remove(user);
          }
      }
        System.out.println("User deleted");
    }

    @Override
    public User login(LoginDTO login) {
        for (User user : users) {
            if (user.getUserName().equals(login.userName()) && user.getPassword().equals(login.password())){
                return user;
            }
        }
        return null;
    }
}
