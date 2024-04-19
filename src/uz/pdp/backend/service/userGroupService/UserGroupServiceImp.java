package uz.pdp.backend.service.userGroupService;

import uz.pdp.backend.entity.userGroup.UserGroup;

import java.util.List;

public class UserGroupServiceImp implements UserGroupService{
    @Override
    public boolean create(UserGroup entity) {
        return false;
    }

    @Override
    public UserGroup get(String id) {
        return null;
    }

    @Override
    public List<UserGroup> getList() {
        return List.of();
    }

    @Override
    public boolean update(UserGroup newEntity) {
return true;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
