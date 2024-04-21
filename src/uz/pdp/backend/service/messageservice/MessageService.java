package uz.pdp.backend.service.messageservice;

import uz.pdp.backend.entity.message.Message;
import uz.pdp.backend.enums.MessageTye;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface MessageService extends BaseService<Message> {
    List<Message> getUsermessage(String id, String s, MessageTye personal);
}
