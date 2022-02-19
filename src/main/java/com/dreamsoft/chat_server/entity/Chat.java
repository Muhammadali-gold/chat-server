//@TypeDef(
//        name = "json", typeClass = JsonType.class
//)

package com.dreamsoft.chat_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Chat")
@Table(name = "chat")
public class Chat extends BaseEntity {


    private String name;

//    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_chat",
            joinColumns = @JoinColumn(name="chat_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy="chat")
    private Set<Message> items;

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.add(user);
    }

}
