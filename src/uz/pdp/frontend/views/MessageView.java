package uz.pdp.frontend.views;

import uz.pdp.backend.entity.message.Message;
import uz.pdp.backend.entity.user.User;
import uz.pdp.backend.enums.MessageTye;
import uz.pdp.backend.service.messageservice.MessageService;
import uz.pdp.backend.service.messageservice.MessageServiceImplementation;
import uz.pdp.backend.service.userservice.UserService;
import uz.pdp.backend.service.userservice.UserServiceImplementation;
import uz.pdp.frontend.utils.MenuUtils;
import uz.pdp.frontend.utils.ScanUtil;

import javax.swing.text.Utilities;
import java.util.List;

public class MessageView {
    private static User currentUser;
    private static UserService userService = UserServiceImplementation.getInstance();
    private static MessageService messageService = MessageServiceImplementation.getInstance();
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
        String name = ScanUtil.scanString("Enter name:");
        List<User> users = userService.getUserByName(name);
        for (int i = 0; i < users.size(); i++) {
            System.out.println(i+1+" "+users.get(i).getUserName());
        }
        int i = ScanUtil.scanInt("Choose user: ")-1;
        String id = users.get(i).getId();
        String s = ScanUtil.scanString("Enter massage: ");
                messageService.create(new Message(currentUser.getId(), id, MessageTye.PERSONAL, s));
    }
}
