package uz.pdp.backend.service.userservice;

import uz.pdp.backend.dto.LoginDTO;
import uz.pdp.backend.dto.SignUpDTO;
import uz.pdp.backend.entity.user.User;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface UserService extends BaseService<User> {
    User login(LoginDTO login);
    void signUp(SignUpDTO signUpDTO);

    List<User> getUserByName(String name);
}
