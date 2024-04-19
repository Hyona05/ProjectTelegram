package uz.pdp.backend.service.charservice;

import uz.pdp.backend.entity.chat.Chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatServiceImplementation implements ChatService{
    private List<Chat> chats;
    private static ChatServiceImplementation chatService;

    private ChatServiceImplementation() {
        this.chats = new ArrayList<>();
    }

    public static ChatServiceImplementation getInstance() {
        if (chatService == null){
            chatService = new ChatServiceImplementation();
        }
        return chatService;
    }

    @Override
    public boolean create(Chat entity) {
        if (entity == null) {
            return false;
        }
        for (Chat existingUser : chats) {
            if (existingUser.getId().equals(entity.getId())) {
                return false;
            }
        }
        chats.add(entity);
        return true;
    }

    @Override
    public Chat get(String id) {
        for (Chat chat : chats) {
            if (chat.getId().equals(id)){
                return chat;
            }
        }
        return null;
    }

    @Override
    public List<Chat> getList() {
        return chats;
    }

    @Override
    public boolean update(Chat newEntity) {
        for (int i = 0; i < chats.size(); i++) {
            if(chats.get(i).getId().equals(newEntity.getId())){
                chats.set(i, newEntity);
                return true;
            }
        }return false;
    }

    @Override
    public boolean delete(String id) {
        for (int i = 0; i < chats.size(); i++) {
            if (chats.get(i).getId().equals(id)){
                chats.remove(i);
                return true;
            }
        }
        return false;
    }
}
