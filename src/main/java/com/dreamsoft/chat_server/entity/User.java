package com.dreamsoft.chat_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "auth_user")
public class User extends BaseEntity {

    private String username;
//    @JsonIgnore
    private String password;

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private Set<Chat> chats = new HashSet<>();


    @JsonIgnore
    @OneToMany(mappedBy="user")
    private Set<Message> messages = new HashSet<>();

    public User() {
    }
}
