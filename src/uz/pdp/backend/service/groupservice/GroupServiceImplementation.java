package uz.pdp.backend.service.groupservice;

import uz.pdp.backend.entity.group.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupServiceImplementation implements GroupService{

    List<Group> groups;
    private GroupServiceImplementation() {
        this.groups = new ArrayList<>();
    }

    @Override
    public void create(Group entity) {

    }

    @Override
    public Group get(String id) {
        return null;
    }

    @Override
    public List<Group> getList() {
        return null;
    }

    @Override
    public void update(Group newEntity) {

    }

    @Override
    public void delete(String id) {

    }

   private static GroupServiceImplementation groupServiceImpl;

    public static GroupServiceImplementation getInstance() {
        if(groupServiceImpl == null){
            groupServiceImpl = new GroupServiceImplementation();
        }
        return groupServiceImpl;
    }

}
