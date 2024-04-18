import uz.pdp.backend.entity.user.User;
import uz.pdp.frontend.utils.MenuUtils;
import uz.pdp.frontend.utils.ScanUtil;
import uz.pdp.frontend.views.LoginView;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Welcome to our TELEGRAM app!!!");
        while (true) {
            int menu = MenuUtils.menu(MenuUtils.LOGIN);
            switch (menu){
                case 1 -> signIn();
                case 2 -> signUp();
                case 3 -> {
                    System.out.println("Come again. Bye bye!");
                    return;
                }
            }
        }
    }

    private static void signUp() {
        User login = LoginView.login();
        if(login!=null){

        }
    }

    private static void signIn() {

    }
}