package uz.pdp.backend.entity.chat;

import uz.pdp.backend.entity.BaseModel;

public class Chat extends BaseModel {
    private String userId;
    private String toId;

    public Chat(String userId, String toId) {
        this.userId = userId;
        this.toId = toId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }
}
