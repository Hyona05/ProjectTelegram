package uz.pdp.backend.entity.message;

import uz.pdp.backend.entity.BaseModel;
import uz.pdp.backend.enums.MessageTye;

public class Message extends BaseModel {
    private String senderId;
    private String toID;
    private MessageTye type;
    private String message;

    public Message(String senderId, String toID, MessageTye type, String message) {
        this.senderId = senderId;
        this.toID = toID;
        this.type = type;
        this.message = message;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getToID() {
        return toID;
    }

    public void setToID(String toID) {
        this.toID = toID;
    }

    public MessageTye getType() {
        return type;
    }

    public void setType(MessageTye type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message [" + message + "] to " + toID;
    }
}
