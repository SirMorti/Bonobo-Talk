package de.bonobo_talk.SpringMVCTest.web;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.bonobo_talk.SpringMVCTest.chat.ChatMessage;
import de.bonobo_talk.SpringMVCTest.chat.OutputChatMessage;
import de.bonobo_talk.SpringMVCTest.model.Chatroom;
import de.bonobo_talk.SpringMVCTest.service.ChatroomService;

@Controller
@RequestMapping("/")
public class ChatController 
{
	
	@Autowired
	ChatroomService chatroomService;
	
	
	/*
	 * takes care of the incoming Chatmessages and broadcasts them to the users in the specified chatroom
	 * also adds a timestamp to the messages
	 */
	@MessageMapping("/chatroom{chatroomID}")
	@SendTo("/topic/chat{chatroomID}")
	public OutputChatMessage broadcast1(@DestinationVariable String chatroomID, ChatMessage chatMessage) throws Exception
	{
		return new OutputChatMessage(chatMessage, new Date());
	}
	
}
