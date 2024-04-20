package uz.pdp.backend.service.userGroupService;

import uz.pdp.backend.entity.userGroup.UserGroup;

import java.util.ArrayList;
import java.util.List;

public class UserGroupServiceImp implements UserGroupService{
    private List<UserGroup> userGroups;
    private static UserGroupServiceImp userGroupService;

    private UserGroupServiceImp(){
        this.userGroups = new ArrayList<>();
    }

    public static UserGroupServiceImp getInstance() {
        if (userGroupService == null){
            userGroupService = new UserGroupServiceImp();
        }
        return userGroupService;
    }
    @Override
    public boolean create(UserGroup entity) {
        this.userGroups.add(entity);
        return true;
    }

    @Override
    public UserGroup get(String id) {
        for (UserGroup userGroup : userGroups) {
            if (userGroup.getId().equals(id)){
                return userGroup;
            }
        }
        return null;
    }

    @Override
    public List<UserGroup> getList() {
        return userGroups;
    }

    @Override
    public boolean update(UserGroup newEntity) {
        for (int i = 0; i < userGroups.size(); i++) {
            if (userGroups.get(i).getId().equals(newEntity.getId())){
                userGroups.set(i,newEntity);
                return true;
            }
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        for (int i = 0; i < userGroups.size(); i++) {
            if (userGroups.get(i).getId().equals(id)){
                userGroups.remove(i);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isUserMember(String userId, String groupId) {
        List<UserGroup> userGroups = getUserGroupsByUserId(userId);
        for (UserGroup userGroup : userGroups) {
            if (userGroup.getGroupId().equals(groupId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<UserGroup> getUserGroupsByUserId(String userId) {
        List<UserGroup> list = new ArrayList<>();
        for (UserGroup userGroup : userGroups) {
            if (userGroup.getUserId().equals(userId)){
                list.add(userGroup);
            }
        }
        return list;
    }
}
