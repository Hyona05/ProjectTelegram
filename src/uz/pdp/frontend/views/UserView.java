package uz.pdp.frontend.views;
import uz.pdp.backend.entity.user.User;
import uz.pdp.frontend.utils.MenuUtils;
import static uz.pdp.frontend.Main.*;


public class UserView {
//    static UserServiceImplementation userService = UserServiceImplementation.getInstance();
//    static GroupServiceImplementation groupService = GroupServiceImplementation.getInstance();
//    static MessageServiceImplementation messageService = MessageServiceImplementation.getInstance();
//    static UserGroupServiceImp userGroupService = UserGroupServiceImp.getInstance();

    public static void profile(User user) {
        currentUser = user;
        while (true) {
            switch (MenuUtils.menu(MenuUtils.USER)) {
                case 1 -> GroupView.profile(user);
                case 2 -> MessageView.profile(user);
                case 0 -> {
                    currentUser = null;
                    System.out.println("Logging out");
                    return;
                }
            }
        }
    }

//    private static void creatGroups() {
//        groupService.create(new Group(ScanUtil.scanString("Enter group name: "), currentUser.getId(), 3));
//    }
//
//    private static void showMyProfile() {
//    }
//
//    private static List<User> showMyContact() {
//        return userService.getList();
//    }
//
//    static void showMyGroup() {
//        for (int i = 0; i < groupService.getList().size(); i++) {
//            if (groupService.getList().get(i).getAdminID().equals(currentUser.getId())) {
//                System.out.println(groupService.getList().get(i));
//            }
//        }
//        for (int i = 0; i < userService.getList().size(); i++) {
//            if (userGroupService.getList().get(i).getUserId().equals(currentUser.getId())) {
//                System.out.println(userGroupService.getList().get(i));
//            }
//        }
//    }
//
//    private static void showMyChats() {
//        for (Message message : messageService.getList()) {
//            if (message.getSenderId().equals(currentUser.getId()) || message.getToID().equals(currentUser.getId())) {
//                System.out.println(message);
//            }
//        }
//    }
}

