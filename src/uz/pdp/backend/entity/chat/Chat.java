package uz.pdp.backend.entity.chat;

import uz.pdp.backend.entity.BaseModel;

public class Chat  extends BaseModel {

   private String user1;
   private String user2;

    public Chat(String user1, String user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    @Override
    public String toString() {
        return "user1='" + user1 +
                ", user2='" + user2;
    }
}
