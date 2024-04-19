package uz.pdp.frontend.views;

import uz.pdp.backend.entity.group.Group;
import uz.pdp.backend.entity.user.User;
import uz.pdp.backend.entity.userGroup.UserGroup;
import uz.pdp.backend.service.groupservice.GroupServiceImplementation;
import uz.pdp.backend.service.messageservice.MessageServiceImplementation;
import uz.pdp.backend.service.userGroupService.UserGroupServiceImp;
import uz.pdp.backend.service.userservice.UserServiceImplementation;
import uz.pdp.frontend.utils.MenuUtils;
import uz.pdp.frontend.utils.ScanUtil;

import java.util.ArrayList;
import java.util.List;

import static uz.pdp.frontend.views.UserView.showMyGroup;

public class
 GroupView {
    private static User currentUser;
    static UserServiceImplementation userService = UserServiceImplementation.getInstance();
    static GroupServiceImplementation groupService = GroupServiceImplementation.getInstance();
    static MessageServiceImplementation messageService = MessageServiceImplementation.getInstance();
    static UserGroupServiceImp userGroupService = UserGroupServiceImp.getInstance();
    public static void profile(User user) {
        currentUser = user;
        while (true){
            switch (MenuUtils.menu(MenuUtils.GROUP)){
                case 1->createGroup();
                case 2->showMyGroup();
                case 3->joinGroup();
                case 4->addUser();
                case 5->sendMessage();
                case 6->setting();
                case 7->deleteGroup();
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
        userGroupService.create(new UserGroup(currentUser.getId(),groupService.getList().get(i).getId()));

    }
    private static void showAllGroups() {
        List<Group> groups = new ArrayList<>();


        for (Group group : groupService.getList()) {
            if (!group.getAdminID().equals(currentUser.getId())) {
                groups.add(group);
            }
        }

        for (UserGroup userGroup : userGroupService.getList()) {
            if (!userGroup.getUserId().equals(currentUser.getId())) {
                Group group = groupService.getGroupById(userGroup.getGroupId());
                if (group != null) {
                    groups.add(group);
                }
            }
        }
    }


    private static void showMyGroup(){

    }

    private static void deleteGroup() {
    }

    private static void setting() {
    }

    private static void sendMessage() {
    }

    private static void addUser() {
    }

    private static void createGroup() {
        groupService.create(new Group(ScanUtil.scanString("Enter group name: "), currentUser.getId(),3));
    }
}
