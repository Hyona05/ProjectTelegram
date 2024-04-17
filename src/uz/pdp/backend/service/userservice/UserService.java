package uz.pdp.backend.service.userservice;

import uz.pdp.backend.dto.LoginDTO;
import uz.pdp.backend.dto.SignUpDTO;
import uz.pdp.backend.entity.user.User;
import uz.pdp.backend.service.BaseService;

public interface UserService extends BaseService<User> {
    User login(LoginDTO login);
    void signUp(SignUpDTO signUp);
}
