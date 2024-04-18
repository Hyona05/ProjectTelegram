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
     groups.add(entity);
        System.out.println("Group created");
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
    public void update(Group newEntity) {
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId().equals(newEntity.getId())) {
                groups.set(i, newEntity);
                System.out.println("Group updated");
                return;
            }
        }
    }

    @Override
    public void delete(String id) {
     for (Group group : groups) {
         if (group.getId().equals(id)) {
             groups.remove(group);
             System.out.println("Group deleted");
             return;
         }
      }
    }

   private static GroupServiceImplementation groupServiceImpl;

    public static GroupServiceImplementation getInstance() {
        if(groupServiceImpl == null){
            groupServiceImpl = new GroupServiceImplementation();
        }
        return groupServiceImpl;
    }

}
