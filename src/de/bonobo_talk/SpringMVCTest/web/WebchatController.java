package de.bonobo_talk.SpringMVCTest.web;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import de.bonobo_talk.SpringMVCTest.model.Chatroom;
import de.bonobo_talk.SpringMVCTest.model.FAQItem;
import de.bonobo_talk.SpringMVCTest.model.Kontakt;
import de.bonobo_talk.SpringMVCTest.model.User;
import de.bonobo_talk.SpringMVCTest.service.ChatroomService;
import de.bonobo_talk.SpringMVCTest.service.UserService;

@Controller

public class WebchatController 
{
		    @Autowired
		    UserService service;   
		    @Autowired
		    MessageSource messageSource;
		    @Autowired
		    ChatroomService chatroomService;
		 
		    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
		    public String showStartsite(ModelMap model) {
		    	if(getPrincipal() != null)
		    	{
			    	service.leaveAllChatrooms(getPrincipal());
		    		return "redirect:/startseite";
		    	}
		        return "index";
		    }
/*
		    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
		    public String listUsers(ModelMap model) {
		 
		        List<User> Users = service.getAllUser();
		        model.addAttribute("Users", Users);
		        return "allUsers";
		    }
		    
*/
		    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
		    public String newUser(ModelMap model) {
		        User User = new User();
		        model.addAttribute("User", User);
		        model.addAttribute("edit", false);
		        return "registration";
		    }

		    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
		    public String saveUser(@Valid @ModelAttribute("User") User User, BindingResult result,
		            ModelMap model) {
		 
		        if (result.hasErrors()) {
		            return "registration";
		        }

		        if(service.findUserByUsername(User.getUsername())!= null){
		            return "registration";
		        }
		         
		        service.saveOrUpdateUser(User);
		 
		        model.addAttribute("success", "User " + User.getUsername() + " registered successfully");
		        return "success";
		    }
		    
		    @RequestMapping(value = { "/startseite" }, method = RequestMethod.GET)
		    public String showStartseite(ModelMap model) {
		        User user = getPrincipal();
		        if(user == null)
		        {
		        	return "redirect:/index";
		        }
		        service.leaveAllChatrooms(user);
		    	model.addAttribute("User", user);
		        return "startseite";
		    }
		 		    
		    @RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
		    public String showProfile(ModelMap model) {
		    	User user = getPrincipal();
		        if(user == null)
		        {
		        	return "redirect:/index";
		        }
		        service.leaveAllChatrooms(user);
		    	model.addAttribute("User", user);
		        return "profile";
		    }
		    @RequestMapping(value = { "/updateProfile" }, method = RequestMethod.GET)
		    public String updateProfile(ModelMap model) {
		        User User = getPrincipal();
		        model.addAttribute("User", User);
		        model.addAttribute("edit", false);
		        return "updateProfile";
		    }
		    
		    @RequestMapping(value = { "/updateProfile" }, method = RequestMethod.POST)
		    public String saveProfile(@Valid @ModelAttribute("User") User User, BindingResult result,
		            ModelMap model) {
		         
		        service.saveOrUpdateUser(User);
		 
		        model.addAttribute("success", "User " + User.getUsername() + " updated successfully");
		        return "success";
		    }
		    
		    @RequestMapping(value = { "/chatselect" }, method = RequestMethod.GET)
		    public String selectChatroom(ModelMap model) {
		    	User user = getPrincipal();
		        if(user == null)
		        {
		        	return "redirect:/index";
		        }
		        service.leaveAllChatrooms(user);
		    	model.addAttribute("User", user);
		        model.addAttribute("Chatrooms", chatroomService.getAllChatrooms());
		        for (Chatroom chatroom : chatroomService.getAllChatrooms()) {
					System.out.println(chatroom.getChatroomname());
				}
		        model.addAttribute("Categories", chatroomService.getAllCategories());
		        return "chatselect";
		    }
		    
		    @RequestMapping(value = { "/joinChatroom" }, method = RequestMethod.POST)
		    public String joinChatroom(@RequestParam("chatroomId") int chatroomId, ModelMap model) 
		    {
		    	User user = getPrincipal();
		        if(user == null)
		        {
		        	return "redirect:/index";
		        }
		        Chatroom tmpChatroom = chatroomService.findById(chatroomId);
		    	if(tmpChatroom == null || tmpChatroom.getMaxUser() <= tmpChatroom.getActiveUser().size() )
		    	{
		    		return "redirect:/chatselect";
		    	}
		        service.leaveAllChatrooms(user);
		    	service.joinChatroom(user.getId(), tmpChatroom);
		    	// chatroom wird neu aus der Datenbank geholt, damit der neue User in der Liste der beigetretenen User steht
		    	model.addAttribute("Chatroom", chatroomService.findById(chatroomId));
		    	model.addAttribute("User", user);
		    	return "chat";
		    }
		    
		    @RequestMapping(value = {"/faq"}, method = RequestMethod.GET)
		    public String showFAQ(ModelMap model)
		    {
		    	User user = getPrincipal();
		    	if(user != null)
		    	{
		    		service.leaveAllChatrooms(user);
		    	}
		    	model.addAttribute("User", user);
		    	return "faq";
		    }
		    
		    @RequestMapping(value = { "/contact" },method = RequestMethod.GET)
		    public String addContact(ModelMap model) {
		    	Kontakt contact = new Kontakt();
		    	FAQItem faqItem = new FAQItem();
		    	
		    	model.addAttribute("User", getPrincipal());
		    	model.addAttribute("contact", contact);
		    	model.addAttribute("faqItem", faqItem);
		    	
		        return "contact";
		    }
		    
		    @RequestMapping(value = { "/createChatroom" }, method = RequestMethod.POST)
		    public String createChatroom(@RequestParam("chatroomName") String chatroomName, @RequestParam("category") String category, ModelMap model) 
		    {
		    	User user = getPrincipal();
		        if(user == null)
		        {
		        	return "redirect:/index";
		        }
		    	chatroomService.createNewChatroom(chatroomName, 32, category);
		    	return "redirect:/chatselect";

		    }
		   
		    @RequestMapping(value = { "/imprint" }, method = RequestMethod.GET)
		    public String showImprint(ModelMap model) {
		        User user = getPrincipal();
		        if(user != null)
		        {
		        	service.leaveAllChatrooms(user);
		        }
		    	model.addAttribute("User", user);
		        return "imprint";
		    }
		    
		    /*
		     * returns the current user
		     */
		    private User getPrincipal(){
		        String userName = null;
		        User user;
		        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		        //TODO: müll nach username suchen
		        if (principal instanceof UserDetails) {
		            userName = ((UserDetails)principal).getUsername();
		            user = service.findUserByUsername(userName);
		            
		        } else {
		            userName = principal.toString();
		            user = null;
		        }
		        
		        return user;
		    }
}
