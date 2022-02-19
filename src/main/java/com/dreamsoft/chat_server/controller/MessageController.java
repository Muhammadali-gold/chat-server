package com.dreamsoft.chat_server.controller;

import com.dreamsoft.chat_server.entity.Chat;
import com.dreamsoft.chat_server.entity.Message;
import com.dreamsoft.chat_server.entity.User;
import com.dreamsoft.chat_server.services.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path={"messages"})
public class MessageController {


    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }



    @RequestMapping(path = "",method = {RequestMethod.GET})
    public List<Message> getMessageList(){
        return messageService.findAllMessage().
                stream().
                map(MessageController::cleanMessage)
                .collect(Collectors.toList());
    }

    @RequestMapping(path = "{id}",method = {RequestMethod.GET})
    public Message getMessage(@PathVariable("id") Long id){
        Message message = messageService.findMessage(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Message not found with id=" + id
                ));

        return cleanMessage(message);
    }

    @RequestMapping(path = "",method = {RequestMethod.POST})
    public String saveMessage(@RequestBody Message message){
        messageService.addMessage(message);
        return "Success";
    }

    @RequestMapping(path = "{id}",method = {RequestMethod.PUT})
    public String updateMessage(@PathVariable("id") Long id,@RequestBody Message message){
        messageService.updateMessage(message,id);
        return "Updated";
    }

    @RequestMapping(path = "{id}",method = {RequestMethod.DELETE})
    public String deleteMessage(@PathVariable("id") Long id){
        messageService.deleteMessage(id);
        return "Deleted";
    }


    private static Message cleanMessage(Message message){
        Chat chat = new Chat();
        chat.setId(message.getChat().getId());
        message.setChat(chat);
        User user = new User();
        user.setId(message.getUser().getId());
        message.setUser(user);
        return message;
    }
}
