package uz.pdp.frontend.views;

import uz.pdp.backend.entity.group.Group;
import uz.pdp.backend.entity.message.Message;
import uz.pdp.backend.entity.user.User;
import uz.pdp.backend.entity.userGroup.UserGroup;
import uz.pdp.backend.enums.MessageTye;
import uz.pdp.backend.service.groupservice.GroupService;
import uz.pdp.backend.service.groupservice.GroupServiceImplementation;
import uz.pdp.backend.service.messageservice.MessageServiceImplementation;
import uz.pdp.backend.service.userGroupService.UserGroupServiceImp;
import uz.pdp.backend.service.userservice.UserServiceImplementation;
import uz.pdp.frontend.utils.MenuUtils;
import uz.pdp.frontend.utils.ScanUtil;

import java.util.List;

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


    private static void showMyGroup(){
        int index = 1;
        for (Group group : groupService.getList()) {
            for (UserGroup userGroup : userGroupService.getList()) {
                if (group.getId().equals(userGroup.getGroupId())) {
                    System.out.println(index + "." + group.getGroupName());
                }
            }
        }
    }

    private static void sendMessage() {
        showMyGroup();
        int i = ScanUtil.scanInt("Choose a group: ") - 1;
        String s = ScanUtil.scanString("Enter the message: ");
        messageService.create(new Message(currentUser.getId(), groupService.getList().get(i).getId(), MessageTye.GROUP,s));
        System.out.println("Message added");

    }

    private static void addUser() {

    }

    private static void createGroup() {
        groupService.create(new Group(ScanUtil.scanString("Enter group name: "), currentUser.getId(),
                ScanUtil.scanInt("Enter group amount: ")));
    }
}
