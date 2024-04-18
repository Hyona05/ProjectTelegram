package uz.pdp.frontend.views;

import uz.pdp.backend.entity.user.User;
import uz.pdp.frontend.utils.MenuUtils;

public class UserView {
    private static User currentUser;
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

    private static void showMyContact() {
    }

    private static void showMyGroup() {
    }

    private static void showMyChats() {
    }

}
