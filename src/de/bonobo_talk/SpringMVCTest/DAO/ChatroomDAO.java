package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.Chatroom;

/*
 * 
 */
public interface ChatroomDAO 
{
	/*
	 * returns the chatroom by id
	 * if no chatroom with the given id could be found will return null
	 */
    Chatroom findById(int id);
    /*
     * saves the given chatroom in the database
     */
    void saveChatroom(Chatroom chatroom);  
    /*
     * deletes the chatroom by id
     */
    void deleteChatroomById(int id);
    /*
     *returns all chatrooms 
     */
    List<Chatroom> getAllChatrooms();
}
