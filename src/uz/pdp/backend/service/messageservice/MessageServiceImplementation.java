package uz.pdp.backend.service.messageservice;

import uz.pdp.backend.entity.message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessageServiceImplementation implements MessageService{
    private List<Message> messages;

    private MessageServiceImplementation() {
        this.messages = new ArrayList<>();
    }

    @Override
    public boolean create(Message entity) {
      messages.add(entity);
      return true;
    }

    @Override
    public Message get(String id) {
        for (Message message : messages) {
            if(message.getId().equals(id)){
                return message;
            }
        }return null;
    }

    @Override
    public List<Message> getList() {
        return messages;
    }

    @Override
    public void update(Message newEntity) {
        for (int i = 0; i < messages.size(); i++) {
            if(messages.get(i).getId().equals(newEntity.getId())){
                messages.set(i, newEntity);
            }
        }
    }

    @Override
    public boolean delete(String id) {
        for (int i = 0; i < messages.size(); i++) {
            Message message = messages.get(i);
            if(message.getId().equals(id)){
                messages.remove(i);
                return true;
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
