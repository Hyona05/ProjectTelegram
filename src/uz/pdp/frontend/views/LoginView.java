package uz.pdp.frontend.views;

import uz.pdp.backend.dto.LoginDTO;
import uz.pdp.backend.entity.user.User;
import uz.pdp.backend.enums.UserStatus;
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
        userService.create(new User(ScanUtil.scanString("Enter firstName: "),
                ScanUtil.scanString("Enter lastName: "),
                ScanUtil.scanString("Enter userName: "),
                ScanUtil.scanString("Enter password: "),
                ScanUtil.scanInt("Enter age: "),
                ScanUtil.scanString("Enter phoneNumber: "),
                chooseStatus()));
    }

    private static UserStatus chooseStatus() {
        System.out.println(UserStatus.getList());
        int i = ScanUtil.scanInt("Enter status: ");
        return UserStatus.getCategoryByOrdinal(i);
    }
}
