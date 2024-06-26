package uz.pdp.backend.service.groupservice;

import uz.pdp.backend.entity.group.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupServiceImplementation implements GroupService{
    private List<Group> groups;
    private static GroupServiceImplementation groupServiceImpl;

    public static GroupServiceImplementation getInstance() {
        if(groupServiceImpl == null){
            groupServiceImpl = new GroupServiceImplementation();
        }
        return groupServiceImpl;
    }
    private GroupServiceImplementation() {
        this.groups = new ArrayList<>();
        this.groups.add(new Group("G40","",3));
    }

    @Override
    public boolean create(Group entity) {
        if (entity == null) {
            return false;
        }
        for (Group existingUser : groups) {
            if (existingUser.getId().equals(entity.getId())) {
                return false;
            }
        }
        groups.add(entity);
        return true;
    }

    @Override
    public Group get(String id) {
        for (Group group : groups) {
            if (group.getId().equals(id)) {
                return group;
            }
        }
        return null;
    }

    @Override
    public List<Group> getList() {
        return groups;
    }

    @Override
    public boolean update(Group newEntity) {
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId().equals(newEntity.getId())) {
                groups.set(i, newEntity);
                return true;
            }
        }return false;
    }

    @Override
    public boolean delete(String id) {
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId().equals(id)){
                groups.remove(i);
                return true;
            }
        }
        return false;
    }
    public Group getGroupById(String groupId) {
        for (Group group : groups) {
            if (group.getId().equals(groupId)) {
                return group;
            }
        }
        return null;
    }

}
