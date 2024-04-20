package uz.pdp.backend.service.userGroupService;

import uz.pdp.backend.entity.userGroup.UserGroup;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface UserGroupService extends BaseService<UserGroup> {
    boolean isUserMember(String userId, String groupId);
    List<UserGroup> getUserGroupsByUserId(String userId);
}
