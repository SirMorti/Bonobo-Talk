package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.Chatroom;


public interface ChatroomDAO 
{
    Chatroom findById(int id);
    void saveChatroom(Chatroom chatroom);  
    void deleteChatroomBySsn(String ssn);
    List<Chatroom> getAllChatrooms();
    Chatroom findChatroomBySsn(String ssn);
}
