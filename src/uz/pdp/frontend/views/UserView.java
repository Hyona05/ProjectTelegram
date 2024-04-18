package uz.pdp.frontend.views;

import uz.pdp.backend.entity.chat.Chat;
import uz.pdp.backend.entity.group.Group;
import uz.pdp.backend.entity.message.Message;
import uz.pdp.backend.entity.user.User;
import uz.pdp.backend.service.groupservice.GroupServiceImplementation;
import uz.pdp.backend.service.messageservice.MessageServiceImplementation;
import uz.pdp.backend.service.userservice.UserServiceImplementation;
import uz.pdp.frontend.utils.MenuUtils;

import java.util.List;

public class UserView {
    private static User currentUser;
    static UserServiceImplementation userService = UserServiceImplementation.getInstance();
    static GroupServiceImplementation groupService = GroupServiceImplementation.getInstance();
    static MessageServiceImplementation messageService = MessageServiceImplementation.getInstance();
    public static void profile(User user) {
        currentUser = user;
        while (true){
            switch (MenuUtils.menu(MenuUtils.USER)){
                case 1->showMyChats();
                case 2->showMyGroup();
                case 3->showMyContact();
                case 4->showMyProfile();
                case 0->{
                    currentUser = null;
                    System.out.println("Logging out");
                    return;
                }
            }
        }
    }

    private static void showMyProfile() {
    }

    private static List<User> showMyContact() {
        return userService.getList();
    }

    private static void showMyGroup() {
        for (Group group : groupService.getList()) {
            if(group.getAdminID().equals(currentUser.getId())){
                System.out.println(group.getGroupName());
            }
        }
    }

    private static void showMyChats() {
        for (Message message : messageService.getList()) {
            if (message.getSenderId().equals(currentUser.getId()) || message.getToID().equals(currentUser.getId())) {
                System.out.println(message);
            }
        }
    }

}
