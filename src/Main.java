import uz.pdp.backend.entity.user.User;
import uz.pdp.frontend.utils.MenuUtils;
import uz.pdp.frontend.views.LoginView;
import uz.pdp.frontend.views.UserView;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** WELCOME TO TELEGRAM ***");

        while (true){
            switch (MenuUtils.menu(MenuUtils.LOGIN)){
                case 1->{ User loginUser = LoginView.login();
                    if (loginUser!=null){
                            UserView.profile(loginUser);
                        } else {
                        System.out.println("Your password or login incorrect❌❌❌");
                    }
                }
                case 2->LoginView.signUp();
                case 3->{
                    System.out.println("Bye bye");
                    System.exit(0);
                }
            }
        }
    }
}