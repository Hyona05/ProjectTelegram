package uz.pdp.backend.entity.group;

import uz.pdp.backend.entity.BaseModel;
import java.util.Date;


public class Group extends BaseModel {
    private String groupName;
    private String adminID;
    private int groupMembersAmount;

    public Group(String groupName, String adminID, int groupMembersAmount) {
        this.groupName = groupName;
        this.adminID = adminID;
        this.groupMembersAmount = groupMembersAmount;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public int getGroupMembersAmount() {
        return groupMembersAmount;
    }

    public void setGroupMembersAmount(int groupMembersAmount) {
        this.groupMembersAmount = groupMembersAmount;
    }
}
