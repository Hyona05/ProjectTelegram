package uz.pdp.frontend.views;

import uz.pdp.backend.entity.user.User;
import uz.pdp.frontend.utils.MenuUtils;

public class MessageView {
    private static User currentUser;

    public static void profile(User user) {
        currentUser = user;
        while (true) {
            switch (MenuUtils.menu(MenuUtils.MESSAGE)) {
                case 0 -> {
                    currentUser = null;
                    System.out.println("Logging out");
                    return;
                }
            }
        }
    }
}
