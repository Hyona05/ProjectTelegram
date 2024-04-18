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
      messages.add(entity);
        System.out.println("Message created");
    }

    @Override
    public Message get(String id) {
        for (Message m : messages) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public List<Message> getList() {
        return messages;
    }

    @Override
    public void update(Message newEntity) {
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getId().equals(newEntity.getId())) {
                messages.set(i, newEntity);
                System.out.println("Message updated");
                return;
            }
        }
    }

    @Override
    public void delete(String id) {
        for (Message m : messages) {
            if (m.getId().equals(id)) {
                messages.remove(m);
                System.out.println("Message deleted");
                return;
            }
        }
    }

   private static MessageServiceImplementation messageServiceImpl;
    public static MessageServiceImplementation getInstance() {
        if (messageServiceImpl == null) {
            messageServiceImpl = new MessageServiceImplementation();
        }
        return messageServiceImpl;
    }
}
