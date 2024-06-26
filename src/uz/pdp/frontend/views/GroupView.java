package uz.pdp.frontend.views;

import uz.pdp.backend.entity.group.Group;
import uz.pdp.backend.entity.message.Message;
import uz.pdp.backend.entity.user.User;
import uz.pdp.backend.entity.userGroup.UserGroup;
import uz.pdp.backend.enums.MessageTye;
import uz.pdp.backend.service.groupservice.GroupServiceImplementation;
import uz.pdp.backend.service.messageservice.MessageServiceImplementation;
import uz.pdp.backend.service.userGroupService.UserGroupServiceImp;
import uz.pdp.backend.service.userservice.UserServiceImplementation;
import static uz.pdp.frontend.Main.*;
import uz.pdp.frontend.utils.MenuUtils;
import uz.pdp.frontend.utils.ScanUtil;

import java.util.List;

public class
 GroupView {
    static UserServiceImplementation userService = UserServiceImplementation.getInstance();
    static GroupServiceImplementation groupService = GroupServiceImplementation.getInstance();
    static MessageServiceImplementation messageService = MessageServiceImplementation.getInstance();
    static UserGroupServiceImp userGroupService = UserGroupServiceImp.getInstance();
    public static void profile(User user) {
        while (true){
            switch (MenuUtils.menu(MenuUtils.GROUP)){
                case 1->createGroup();
                case 2->showMyGroup();
                case 3->joinGroup();
                case 4->sendMessage();
                case 0->{
                    currentUser = null;
                    System.out.println("Logging out");
                    return;
                }
            }
        }
    }

    private static void joinGroup() {
        showAllGroups();
        int i = ScanUtil.scanInt("Choose group: ") - 1;
        boolean isMember = userGroupService.isUserMember(currentUser.getId(), groupService.getList().get(i).getId());
        if (isMember) {
            System.out.println("You are already a member of this group.");
            return;
        }
        userGroupService.create(new UserGroup(currentUser.getId(),groupService.getList().get(i).getId()));
        System.out.println("Joined");
    }

    private static void showAllGroups() {
        List<Group> list = groupService.getList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + "." + list.get(i).getGroupName());
        }
    }


    private static String showMyGroup(){
        if (groupException()) {
            System.out.println("You don't have any groups.");
            return  null;
        }
        int index = 1;
        List<UserGroup> userGroupsByUserId = userGroupService.getUserGroupsByUserId(currentUser.getId());
        for (UserGroup userGroup : userGroupsByUserId) {
            System.out.println((index) + groupService.get(userGroup.getGroupId()).getGroupName());
        }

        int chosenGroup = ScanUtil.scanInt("Choose  group: ")-1;
       return userGroupsByUserId.get(chosenGroup).getGroupId();

    }

    private static void sendMessage() {
        if (groupException()) {
            System.out.println("You don't have any groups to send a message to.");
            return;
        }
        String groupId = showMyGroup();
        if (groupId == null) {
            System.out.println("You don't have any groups to send a message to.");
            return;
        }
        String s = ScanUtil.scanString("Enter the message: ");
        messageService.create(new Message(currentUser.getId(), groupId,MessageTye.GROUP,s));
        System.out.println("*");
    }

    private static void createGroup() {
        groupService.create(new Group(ScanUtil.scanString("Enter group name: "), currentUser.getId(),
                ScanUtil.scanInt("Enter group amount: ")));
    }
    private static boolean groupException(){
        List<UserGroup> groups = userGroupService.getList();
        if (groups.isEmpty()) {
            return true;
        }
        return false;
    }
}
