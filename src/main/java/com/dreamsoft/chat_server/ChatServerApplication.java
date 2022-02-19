package com.dreamsoft.chat_server;

import com.dreamsoft.chat_server.entity.Chat;
import com.dreamsoft.chat_server.entity.Message;
import com.dreamsoft.chat_server.entity.User;
import com.dreamsoft.chat_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ChatServerApplication implements CommandLineRunner {

	@Autowired
	private UserRepository vehicleRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChatServerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Hello");
//		User muhammadali = new User();
//		muhammadali.setUsername("Muhammadali");
//		muhammadali.setPassword("pass");
//
//		Chat m_chat = new Chat();
//		m_chat.setName("qizg'in suhbat");
//
//		Message m_message = new Message();
//		m_message.setText("qalaysilar?");
//		muhammadali.getChats().add(m_chat);
	}
}
