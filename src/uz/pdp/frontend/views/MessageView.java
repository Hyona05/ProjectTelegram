package uz.pdp.frontend.views;

import uz.pdp.backend.entity.user.User;
import uz.pdp.frontend.utils.MenuUtils;

public class MessageView {
    private static User currentUser;

    public static void profile(User user) {
        currentUser = user;
        while (true) {
            switch (MenuUtils.menu(MenuUtils.MESSAGE)) {
                case 1 -> sentMessage();
                case 2 -> showMessages();
                case 3 -> deleteChat();
                case 4 -> settings();
                case 0 -> {
                    currentUser = null;
                    System.out.println("Logging out");
                    return;
                }
            }
        }
    }

    private static void settings() {

    }

    private static void deleteChat() {

    }

    private static void showMessages() {

    }

    private static void sentMessage() {

    }
}
