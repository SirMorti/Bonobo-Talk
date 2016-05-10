package de.bonobo_talk.SpringMVCTest.service;

import java.util.List;
import java.util.Set;

import de.bonobo_talk.SpringMVCTest.model.Chatroom;
import de.bonobo_talk.SpringMVCTest.model.User;

public interface UserService {
	
	User findById(int id);
    void saveOrUpdateUser(User user);  
    void deleteUser(String username);
    void deleteUser(int id);
    List<User> getAllUser();
    User findUserByUsername(String username);
    void addFavouriteChatroom(int userID, Chatroom chatroom);
    void removeFavouriteChatroom(int userID, Chatroom chatroom);
    void joinChatroom(int userID, Chatroom chatroom);
    void leaveChatroom(int userID, Chatroom chatroom);
    Set<String> getAllUsernames();
    public void leaveAllChatrooms(User user);
     
}