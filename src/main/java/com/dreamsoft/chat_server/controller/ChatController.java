package com.dreamsoft.chat_server.controller;

import com.dreamsoft.chat_server.entity.Chat;
import com.dreamsoft.chat_server.services.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path={"chats"})
public class ChatController {


    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }


    @RequestMapping(path = "",method = {RequestMethod.GET})
    public List<Chat> getChatList(){
        return chatService.findAllChat();
    }

    @RequestMapping(path = "{id}",method = {RequestMethod.GET})
    public Chat getChat(@PathVariable("id") Long id){
        return chatService.findChat(id)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Chat not found with id="+id
                    ));
    }

    @RequestMapping(path = "",method = {RequestMethod.POST})
    public String addChat(@RequestBody Chat chat){
        chatService.addChat(chat);
        return "Success";
    }

    @RequestMapping(path = "{id}",method = {RequestMethod.PUT})
    public String updateChat(@PathVariable("id") Long id,@RequestBody Chat chat){
        chatService.updateChat(chat,id);
        return "Updated";
    }

    @RequestMapping(path = "{id}",method = {RequestMethod.DELETE})
    public String deleteChat(@PathVariable("id") Long id){
       chatService.deleteChat(id);
       return "Deleted";
    }
}
