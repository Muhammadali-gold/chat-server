//package com.dreamsoft.chat_server.entity;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//class UserChat {
//
//    @Id
//    Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    User User;
//
//    @ManyToOne
//    @JoinColumn(name = "chat_id")
//    Chat chat;
//
//    LocalDateTime registeredAt;
//
//    int grade;
//
//    int rating;
//
//}
