package de.bonobo_talk.SpringMVCTest.service;

import java.util.List;


import java.util.Set;

import de.bonobo_talk.SpringMVCTest.model.Chatroom;

public interface ChatroomService 
{
    Chatroom findById(int id);     
    void saveChatroom(Chatroom chatroom);    
    void updateChatroom(Chatroom chatroom);    
    void deleteChatroomBySsn(String ssn); 
    List<Chatroom> getAllChatrooms(); 
    Chatroom findChatroomBySsn(String ssn);
    boolean isChatroomSsnUnique(Integer id, String ssn);
    Set<String> getAllCategories();
}
