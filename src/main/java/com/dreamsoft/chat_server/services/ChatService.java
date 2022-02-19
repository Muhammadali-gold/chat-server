package com.dreamsoft.chat_server.services;

import com.dreamsoft.chat_server.entity.Chat;
import com.dreamsoft.chat_server.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public void addChat(Chat chat){
        chatRepository.save(chat);
    }

    public Optional<Chat> findChat(Long id){
        return chatRepository.findById(id);
    }

    public List<Chat> findAllChat(){
        return chatRepository.findAll();
    }

    public void deleteChat(Long id){
        chatRepository.deleteById(id);
    }

    public void updateChat(Chat chat, Long id){
        Optional<Chat> database_user = chatRepository.findById(id);
        database_user.ifPresent(value -> chat.setCreatedAt(value.getCreatedAt()));
        chat.setId(id);
        chatRepository.save(chat);
    }

}
