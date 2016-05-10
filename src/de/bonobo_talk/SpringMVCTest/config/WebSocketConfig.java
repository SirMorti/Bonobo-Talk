package de.bonobo_talk.SpringMVCTest.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import de.bonobo_talk.SpringMVCTest.model.Chatroom;
import de.bonobo_talk.SpringMVCTest.service.ChatroomService;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer
{
	@Autowired
	ChatroomService chatroomService;
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) 
	{
		// TODO Auto-generated method stub
		//Fix the latest Chatroom for some reason gets not registered therfore its automatically added
		int id = 0;
		registry.addEndpoint("/chatroom").withSockJS();
		for (Chatroom chatroom : chatroomService.getAllChatrooms()) {
			registry.addEndpoint("/chatroom" + chatroom.getId()).withSockJS();
			if (id < chatroom.getId())
			{
				id = chatroom.getId();
			}
		}
		registry.addEndpoint("/chatroom" + Integer.toString(id + 1)).withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config)
	{
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/chat");
	}

}
