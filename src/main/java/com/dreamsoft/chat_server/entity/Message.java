package com.dreamsoft.chat_server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Message")
@Table(name = "message")
public class Message extends BaseEntity {


    @ManyToOne
    @JoinColumn(name="chat_id", nullable=false)
    private Chat chat;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Column(columnDefinition="TEXT")
    @Size(max=10000)
    private String text;

}
