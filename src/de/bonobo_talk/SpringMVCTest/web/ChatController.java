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
/*	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String viewChat()
	{
		return "chat";
	}
*/	
	@Autowired
	ChatroomService chatroomService;
	
    @RequestMapping(value = { "/generateChatrooms" }, method = RequestMethod.GET)
    public String generateChatrooms(ModelMap model) {
        
    	Chatroom chatroom1 = new Chatroom();
    	chatroom1.setChatroomname("Bonobo");
    	chatroom1.setMaxUser(64);
    	chatroom1.setSsn("fuckingSsn");
    	chatroom1.setCategory("Affen");
    	
    	Chatroom chatroom3 = new Chatroom();
    	chatroom3.setChatroomname("Schimpanse");
    	chatroom3.setMaxUser(64);
    	chatroom3.setSsn("Ssn");
    	chatroom3.setCategory("Affen");
    	
    	Chatroom chatroom2 = new Chatroom();
    	chatroom2.setChatroomname("Haters gonna hate Hibernate");
    	chatroom2.setMaxUser(64);
    	chatroom2.setSsn("someStupidSsn");
    	chatroom2.setCategory("Andere");
    	
    	chatroomService.saveChatroom(chatroom1);
    	chatroomService.saveChatroom(chatroom2);
    	chatroomService.saveChatroom(chatroom3);
    	
        return "redirect:/chatselect";
    }
	
	
	@MessageMapping("/chatroom{chatroomID}")
	@SendTo("/topic/chat{chatroomID}")
	public OutputChatMessage broadcast1(@DestinationVariable String chatroomID, ChatMessage chatMessage) throws Exception
	{
		return new OutputChatMessage(chatMessage, new Date());
	}
	
}
