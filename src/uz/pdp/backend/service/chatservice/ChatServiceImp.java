package uz.pdp.backend.service.chatservice;

import uz.pdp.backend.entity.chat.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatServiceImp implements ChatService{
    private List<Chat> chats;
    private static ChatServiceImp chatService;

    private ChatServiceImp() {
        this.chats = new ArrayList<>();
    }

    public static ChatServiceImp getInstance() {
        if (chatService == null){
            chatService = new ChatServiceImp();
        }
        return chatService;
    }
    @Override
    public boolean create(Chat entity) {
        this.chats.add(entity);
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
            if (chats.get(i).getId().equals(newEntity.getId())) {
                chats.set(i, newEntity);
                return true;
            }
        }
        return false;
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
