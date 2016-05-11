package de.bonobo_talk.SpringMVCTest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.bonobo_talk.SpringMVCTest.model.Chatroom;
import de.bonobo_talk.SpringMVCTest.model.FAQItem;
import de.bonobo_talk.SpringMVCTest.model.Kontakt;
import de.bonobo_talk.SpringMVCTest.model.User;
import de.bonobo_talk.SpringMVCTest.service.ChatroomService;
import de.bonobo_talk.SpringMVCTest.service.FAQItemService;
import de.bonobo_talk.SpringMVCTest.service.KontaktService;
import de.bonobo_talk.SpringMVCTest.service.UserService;

@Controller
@RequestMapping("/Test/")
public class TestController {
	
	@Autowired
	ChatroomService chatroomService;
	
	@Autowired
	FAQItemService faqService;
	
	@Autowired
	UserService	userService;
	
	@Autowired
	KontaktService kontaktService;
	
	/*
	 * testfunction 
	 * 
	 * creates several chatrooms and stores them in the database
	 * 
	 * prints all chatrooms in database to console
	 * 
	 * prints all categories to console
	 * 
	 * adds a user to the chatroom
	 */
	
	public void testChatrooms()
	{
		Chatroom chatroom1 = new Chatroom();
    	chatroom1.setChatroomname("Bonobo");
    	chatroom1.setMaxUser(64);
    	chatroom1.setCategory("Affen");
    	
    	Chatroom chatroom3 = new Chatroom();
    	chatroom3.setChatroomname("Schimpanse");
    	chatroom3.setMaxUser(64);
    	chatroom3.setCategory("Affen");
    	
    	Chatroom chatroom2 = new Chatroom();
    	chatroom2.setChatroomname("Haters gonna hate Hibernate");
    	chatroom2.setMaxUser(64);
    	chatroom2.setCategory("Andere");
    	
    	chatroomService.saveChatroom(chatroom1);
    	chatroomService.saveChatroom(chatroom2);
    	chatroomService.saveChatroom(chatroom3);
    	
    	for (Chatroom chatroom : chatroomService.getAllChatrooms()) {
			System.out.println(chatroom.toString());
		}
    	
    	System.out.println(chatroomService.getAllCategories().toString());
	}
	
	@RequestMapping(value = { "/testChatrooms" }, method = RequestMethod.GET)
    public String testChatrooms(ModelMap model) {
        
    	testChatrooms();    	
        return "redirect:/chatselect";
    }
	
	/*
	 * testfunction for faq
	 * 
	 * creates several faqItems and kontakte
	 * 
	 * gets the faqItems from the database and prints them to console
	 * 
	 * gets the Kontakte from the database and prints them to console
	 */
	
	public void testFAQItem()
	{
		FAQItem item1 = new FAQItem();
		item1.setBetreff("Test FAQ");
		item1.setInhalt("Dies ist eine Testfrage");
		
		FAQItem item2 = new FAQItem();
		item2.setBetreff("Luzifer");
		item2.setInhalt("Testantwort Yea Yea");
		item2.setFrage(item1);
		
		FAQItem item3 = new FAQItem();
		item3.setBetreff("Beelzebub");
		item3.setInhalt("LOLOLOLO wir sind so toll");
		item3.setFrage(item1);
		
		Kontakt kontakt1 = new Kontakt();
		kontakt1.setE_mail("somemail@mail.de");
		kontakt1.setName("Max");
		kontakt1.setVorname("Mustermann");
		
		Kontakt kontakt2 = new Kontakt();
		kontakt2.setE_mail("othermaill@mail.de");
		kontakt2.setName("Karl");
		kontakt2.setVorname("Muster");
		
		Kontakt kontakt3 = new Kontakt();
		kontakt3.setE_mail("trial@extrem.de");
		kontakt3.setName("Lisa");
		kontakt3.setVorname("Kaluch");
		
		item1.setKontakt(kontakt1);
		item2.setKontakt(kontakt2);
		item3.setKontakt(kontakt3);
		
		faqService.saveOrUpdateFAQItem(item1);
		faqService.saveOrUpdateFAQItem(item2);		
		faqService.saveOrUpdateFAQItem(item3);
		
		faqService.addAntwort(item1, item2);
		faqService.addAntwort(item1, item3);
		
		List<FAQItem> test = (List<FAQItem>) faqService.findFAQItemByBetreff("Luzifer");
		for (FAQItem faqItem : test) 
		{
			System.out.println(faqItem.toString());
		}
		
		for (Kontakt kontakt : kontaktService.getAllKontakte()) {
			System.out.println(kontakt.toString());
		}
		
	}
	
	@RequestMapping(value = { "/testFAQ" }, method = RequestMethod.GET)
    public String testFAQ(ModelMap model) {
 
		testFAQItem();
		return "redirect:/index";
    }
	
	/*
	 * testfunction for user
	 * 
	 * creates and stores user in the database
	 * 
	 * finds user by username
	 * 
	 * prints the user to console
	 * 
	 * prints all users to console
	 * 
	 * prints all usernames to console
	 */
	
	public void testUser()
	{
		User testUser1 = new User();
		testUser1.setUsername("test1");
		testUser1.setPassword("test");
		testUser1.setFirstname("tester");
		testUser1.setLastname("test");
		testUser1.setEmail("testmail@test.te");
		testUser1.setDateOfBirth("12.12.1989");
		testUser1.setGender("robot");
		testUser1.setUserpicture("SorryDontHaveASelfieStick.png");
		
		User testUser2 = new User();
		testUser2.setUsername("test2");
		testUser2.setPassword("test");
		testUser2.setFirstname("fd");
		testUser2.setLastname("ds");
		testUser2.setEmail("testmail@test.te");
		testUser2.setDateOfBirth("12.12.1989");
		testUser2.setGender("slave");
		testUser2.setUserpicture("SorryDontHaveASelfieStick.png");
		
		userService.saveOrUpdateUser(testUser1);
		userService.saveOrUpdateUser(testUser2);
		
		User tmpUser = userService.findUserByUsername(testUser1.getUsername());
		
		System.out.println(tmpUser.toString());		
		
		for (User user : userService.getAllUser()) {
			System.out.println(user.toString());
		}
		
		System.out.println(userService.getAllUsernames().toString());
		
	}
	
	@RequestMapping(value = { "/testUser" }, method = RequestMethod.GET)
    public String testUser(ModelMap model) {
		
		testUser();
		return "redirect:/index";
	}
	
	/*
	 * testfunction to test the binding between the user and the chatroom
	 * 
	 * starts testUser and testChatroom to generate some data
	 * 
	 * adds a user to a chatroom
	 * 
	 * prints active users of chatroom 
	 * 
	 * removes user von chatroom 
	 * 
	 * prints active users of chatroom
	 * 
	 * adds chatroom as favourite
	 * 
	 * prints favourite chatrooms of user
	 *
	 */
	public void testBinding()
	{
		testUser();
		testChatrooms();
		
		List<User> users = userService.getAllUser();
		
		System.out.println("letting users join chatrooms");
		
		for(User user : users)
		{
			List<Chatroom> chatrooms = chatroomService.getAllChatrooms();
			int anzChatrooms = chatrooms.size() - 1;
			//let user join random chatroom
			userService.joinChatroom(user.getId(), chatrooms.get((int)(Math.random() * 100) % anzChatrooms));
		}
		
		//we have to get the chatrooms again in order to have upToDate data
		for (Chatroom chatroom : chatroomService.getAllChatrooms()) {
			System.out.println("printing active users for: " + chatroom.getChatroomname());
			System.out.println(chatroom.getActiveUser().toString());
		}
		
		System.out.println("users leave all chatrooms");
		
		for (User user : userService.getAllUser()) {
			userService.leaveAllChatrooms(user);
		}
		
		//we have to get the chatrooms again in order to have upToDate data
		for (Chatroom chatroom : chatroomService.getAllChatrooms()) {
			System.out.println("printing active users for: " + chatroom.getChatroomname());
			System.out.println(chatroom.getActiveUser().toString());
		}
		
		for (User user : userService.getAllUser()) {
			List<Chatroom> chatrooms = chatroomService.getAllChatrooms();	
			for (int i = 0; i < chatrooms.size(); i++) 
			{
				if((Math.random() * 100) < 50)
				{
					userService.addFavouriteChatroom(user.getId(), chatrooms.get(i));
				}
			}
		}
		
		for (User user : userService.getAllUser()) {
			System.out.println("favourite CHatrooms of User: " + user.getUsername());
			System.out.println(user.getFavouriteChatrooms().toString());
		}
	}
	
	@RequestMapping(value = { "/testBinding" }, method = RequestMethod.GET)
    public String testBinding(ModelMap model) {
	
		testBinding();
		return "redirect:/index";
	}

}
