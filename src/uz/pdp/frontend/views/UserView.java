package uz.pdp.frontend.views;

import uz.pdp.backend.entity.user.User;
import uz.pdp.backend.service.userservice.UserServiceImplementation;
import uz.pdp.frontend.utils.MenuUtils;
import uz.pdp.frontend.utils.ScanUtil;

import java.util.ArrayList;
import java.util.List;

public class UserView {
    private static User curUser;
    private static List<String> contacts = new ArrayList<>();
    private static UserServiceImplementation userService = UserServiceImplementation.getInstance();

    public static void profile(User login) {
        curUser = login;
        while (true){
            int menu = MenuUtils.menu(MenuUtils.USER);
            switch (menu){
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
        getTelegramContacts();
        for (String contact : contacts) {
            System.out.println(contact);
        }
    }

    private static void ShowMyGroups() {

    }

    private static void ShowMyChats() {

    }
    private static List<String> getTelegramContacts() {
        List<User> list = userService.getList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + "." + list.get(i).getUserName());
        }
        int userInput = ScanUtil.scanInt("Enter user: ") - 1;
        if (userInput >= 0 && userInput < list.size()) {
            String selectedUserName = list.get(userInput).getUserName();
            contacts.add(selectedUserName);
        } else {
            System.out.println("Invalid user selection.");
        }
        return contacts;
    }
}
