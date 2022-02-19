package com.dreamsoft.chat_server.services;

import com.dreamsoft.chat_server.entity.Message;
import com.dreamsoft.chat_server.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void addMessage(Message message){
        messageRepository.save(message);
    }

    public Optional<Message> findMessage(Long id){
        return messageRepository.findById(id);
    }

    public List<Message> findAllMessage(){
        return messageRepository.findAll();
    }

    public void deleteMessage(Long id){
        messageRepository.deleteById(id);
    }

    public void updateMessage(Message message, Long id){
        Optional<Message> database_message = messageRepository.findById(id);
        database_message.ifPresent(value -> message.setCreatedAt(value.getCreatedAt()));
        message.setId(id);
        messageRepository.save(message);
    }

}
