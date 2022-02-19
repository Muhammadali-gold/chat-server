package com.dreamsoft.chat_server.services;

import com.dreamsoft.chat_server.entity.User;
import com.dreamsoft.chat_server.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public Optional<User> findUser(Long id){
        return userRepository.findById(id);
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void updateUser(User user, Long id){
        Optional<User> database_user = userRepository.findById(id);
        database_user.ifPresent(value -> user.setCreatedAt(value.getCreatedAt()));
        user.setId(id);
        userRepository.save(user);
    }

}
