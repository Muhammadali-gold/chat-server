package com.dreamsoft.chat_server.controller;

import com.dreamsoft.chat_server.entity.User;
import com.dreamsoft.chat_server.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path={"users"})
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "",method = {RequestMethod.GET})
    public List<User> getUserList(){
        return userService.findAllUser();
    }

    @RequestMapping(path = "{id}",method = {RequestMethod.GET})
    public User getUser(@PathVariable("id") Long id){
        return userService.findUser(id)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "User not found with id="+id
                    ));
    }

    @RequestMapping(path = "",method = {RequestMethod.POST})
    public String saveUser(@RequestBody User user){
        userService.addUser(user);
        return "Success";
    }

    @RequestMapping(path = "{id}",method = {RequestMethod.PUT})
    public String updateUser(@PathVariable("id") Long id,@RequestBody User user){
       userService.updateUser(user,id);
       return "Updated";
    }

    @RequestMapping(path = "{id}",method = {RequestMethod.DELETE})
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "Deleted";
    }
}
