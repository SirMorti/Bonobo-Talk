package de.bonobo_talk.SpringMVCTest.service;

import java.util.List;


import java.util.Set;

import de.bonobo_talk.SpringMVCTest.model.Chatroom;

public interface ChatroomService 
{
	/*
	 * returns the chatroom by id if no chatroom with a matching id could be found returns null
	 */
    Chatroom findById(int id);     
    /*
     * stores the chatroom in the Database
     */
    void saveChatroom(Chatroom chatroom);    
    /*
     * updates a chatroom in the database
     */
    void updateChatroom(Chatroom chatroom); 
    /*
     * removes a chatroom from the database
     */
    void deleteChatroomById(int id); 
    /*
     * returns a list of all chatrooms
     */
    List<Chatroom> getAllChatrooms(); 
    /*
     * returns a list of all categories chatrooms can belong to
     */
    Set<String> getAllCategories();
    /*
     * checks weather the chatroomName is unique
     */
    boolean isUnique(String chatroomName);
    /*
     * creates a new Chatroom
     * 
     * if error returns false else true
     */
    boolean createNewChatroom(String chatroomName, int maxUser, String category);
}
