package uz.pdp.backend.entity.userGroup;

import uz.pdp.backend.entity.BaseModel;
import uz.pdp.backend.service.BaseService;

public class UserGroup extends BaseModel {
    private String userId;
    private String groupId;

    public UserGroup(String userId, String groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "userId='" + userId + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
