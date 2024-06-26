package uz.pdp.frontend.views;

import uz.pdp.backend.dto.LoginDTO;
import uz.pdp.backend.dto.SignUpDTO;
import uz.pdp.backend.entity.user.User;
import uz.pdp.backend.service.userservice.UserService;
import uz.pdp.backend.service.userservice.UserServiceImplementation;
import uz.pdp.frontend.utils.ScanUtil;

public class LoginView {
    private static UserService userService = UserServiceImplementation.getInstance();

    public static User login(){
        System.out.println("Enter login info");
        String username = ScanUtil.scanString("Enter username: ");
        String password = ScanUtil.scanString("Enter password: ");
        LoginDTO loginDTO = new LoginDTO(username, password);
        return userService.login(loginDTO);
    }
    public static void signUp(){
        System.out.println("Enter your info");
        String name = ScanUtil.scanString("Enter your fullName: ");
        String username = ScanUtil.scanString("Enter your username: ");
        String password =  ScanUtil.scanString("Enter the password: ");
        SignUpDTO signUpDTO = new SignUpDTO(name,username, password);
        userService.signUp(signUpDTO);
        System.out.println("Sign up successful");
    }
}
