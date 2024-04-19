package uz.pdp.frontend.views;

import uz.pdp.backend.entity.chat.Chat;
import uz.pdp.backend.entity.group.Group;
import uz.pdp.backend.entity.user.User;
import uz.pdp.backend.service.charservice.ChatServiceImplementation;
import uz.pdp.backend.service.groupservice.GroupServiceImplementation;
import uz.pdp.backend.service.userservice.UserServiceImplementation;
import uz.pdp.frontend.utils.MenuUtils;
import uz.pdp.frontend.utils.ScanUtil;

import java.util.ArrayList;
import java.util.List;

public class UserView {
    private static User curUser;
    private static List<String> contacts = new ArrayList<>();
    private static UserServiceImplementation userService = UserServiceImplementation.getInstance();
    private static GroupServiceImplementation groupService = GroupServiceImplementation.getInstance();
    private static ChatServiceImplementation chatService = ChatServiceImplementation.getInstance();

    public static void profile(User login) {
        curUser = login;
        while (true) {
            int menu = MenuUtils.menu(MenuUtils.USER);
            switch (menu) {
                case 1 -> ShowMyChats();
                case 2 -> ShowMyGroups();
                case 3 -> ShowMyContact();
                case 0 -> {
                    curUser = null;
                    System.out.println("Logging out");
                    return;
                }
            }
        }
    }

    private static void ShowMyContact() {
        for (String contact : contacts) {
            System.out.println(contact);
        }
    }

    private static void ShowMyGroups() {
        for (Group group : groupService.getList()) {
            System.out.println(group);
        }
    }

    private static void ShowMyChats() {
        for (Chat chat : chatService.getList()) {
            System.out.println(chat);
        }
    }

    private static List<String> getTelegramContacts() {
        List<User> list = userService.getList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + "." + list.get(i).getUserName());
        }
        int userInput = ScanUtil.scanInt("Enter user: ") - 1;
        String selectedUserName = list.get(userInput).getUserName();
        contacts.add(selectedUserName);
        return contacts;
    }
}
