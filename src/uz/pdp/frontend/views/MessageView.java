package uz.pdp.frontend.views;

import uz.pdp.backend.entity.message.Message;
import uz.pdp.backend.entity.user.User;
import uz.pdp.backend.enums.MessageTye;
import uz.pdp.backend.service.messageservice.MessageService;
import uz.pdp.backend.service.messageservice.MessageServiceImplementation;
import uz.pdp.backend.service.userservice.UserService;
import uz.pdp.backend.service.userservice.UserServiceImplementation;
import uz.pdp.frontend.utils.MenuUtils;
import uz.pdp.frontend.utils.ScanUtil;

import static uz.pdp.frontend.Main.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class MessageView {
    private static UserService userService = UserServiceImplementation.getInstance();
    private static MessageService messageService = MessageServiceImplementation.getInstance();

    public static void profile(User user) {
        currentUser = user;
        String id = geToId();
        while (true) {
            switch (MenuUtils.menu(MenuUtils.MESSAGE)) {
                case 1 -> sentMessage(id);
                case 2 -> editMessages(id);
                case 3 -> deleteMessage(id);
                case 0 -> {
                    currentUser = null;
                    System.out.println("Logging out");
                    return;
                }
            }
        }
    }

    private static void editMessages(String id) {
        List<Message> myMessages = getMessages(id);
        int i = ScanUtil.scanInt("Choose messase: ")-1;
        Message message = myMessages.get(i);
        message.setMessage(ScanUtil.scanString("Enter new message: "));
        messageService.update(message);

    }

    private static List<Message> getMessages(String id) {
        List<Message> myMessages = messageService.getMyMessages(currentUser.getId(), id, MessageTye.PERSONAL);
        for (int i = 0; i < myMessages.size(); i++) {
            Message message = myMessages.get(i);
            String name = "\u001B[32m"+userService.get(message.getSenderId()).getFullName()+"\u001B[0m";
            String time = message.getLocalDateTime().format(DateTimeFormatter.ofPattern("HH:mm"));
            System.out.printf("""
                    %s
                    %d.%s
                    %s%n
                    """.formatted(name,(i+1),message.getMessage(),time));
        }
        return myMessages;
    }

    private static void deleteMessage(String id) {
        List<Message> myMessages = getMessages(id);
        int i = ScanUtil.scanInt("Choose messase: ")-1;
        String id1 = myMessages.get(i).getId();
        messageService.delete(id1);
    }

    private static void sentMessage(String id) {
        showMessage(id);
        String s = ScanUtil.scanString("Enter massage: ");
        messageService.create(new Message(currentUser.getId(), id, MessageTye.PERSONAL, s));
    }
    public static String geToId(){
        String name = ScanUtil.scanString("Enter name:");
        List<User> users = userService.getUserByName(name);
        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + 1 + " " + users.get(i).getUserName());
        }
        int i = ScanUtil.scanInt("Choose user: ") - 1;
        return users.get(i).getId();
    }
    public static void showMessage(String id) {
        List<Message> messages = messageService.getUsermessage(currentUser.getId(),id,MessageTye.PERSONAL);
        for (Message message : messages) {
            String name = "\u001B[32m"+userService.get(message.getSenderId()).getFullName()+"\u001B[0m";
            String time = message.getLocalDateTime().format(DateTimeFormatter.ofPattern("HH:mm"));
            System.out.printf("""
                    %s
                    %s
                    %s%n
                    """.formatted(name,message.getMessage(),time));
        }
    }
}
