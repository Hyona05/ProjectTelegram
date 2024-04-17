package uz.pdp.backend.service.messageservice;

import uz.pdp.backend.entity.message.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageServiceImplementation implements MessageService{

    List<Message> messages;
    private MessageServiceImplementation() {
        this.messages = new ArrayList<>();
    }
    @Override
    public void create(Message entity) {

    }

    @Override
    public Message get(String id) {
        return null;
    }

    @Override
    public List<Message> getList() {
        return null;
    }

    @Override
    public void update(Message newEntity) {

    }

    @Override
    public void delete(String id) {

    }

   private static MessageServiceImplementation messageServiceImpl;
    public static MessageServiceImplementation getInstance() {
        if (messageServiceImpl == null) {
            messageServiceImpl = new MessageServiceImplementation();
        }
        return messageServiceImpl;
    }
}
