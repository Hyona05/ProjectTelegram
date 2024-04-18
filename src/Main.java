import uz.pdp.backend.entity.user.User;
import uz.pdp.frontend.utils.MenuUtils;
import uz.pdp.frontend.views.LoginView;
import uz.pdp.frontend.views.UserView;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Telegram program");
        loop:
        while (true) {
            int menu = MenuUtils.menu(MenuUtils.LOGIN);
            switch (menu) {
                case 1 -> {
                    User login = LoginView.login();
                    if (login != null) {
                        UserView.profile(login);
                    } else {
                        System.out.println("Your pass or login incorrent❌");
                    }
                }
                case 2 -> {
                    LoginView.signUp();
                }
                case 0 -> {
                    System.out.println("Bye bye");
                    break loop;
                }
            }
        }
    }
}