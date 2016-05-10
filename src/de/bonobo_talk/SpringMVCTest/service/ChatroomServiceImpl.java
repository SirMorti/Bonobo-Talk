package de.bonobo_talk.SpringMVCTest.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.bonobo_talk.SpringMVCTest.DAO.ChatroomDAO;
import de.bonobo_talk.SpringMVCTest.model.Chatroom;

@Service("ChatroomService")
@Transactional
public class ChatroomServiceImpl implements ChatroomService {

	@Autowired
	private ChatroomDAO dao;
	
	@Override
	public Chatroom findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void saveChatroom(Chatroom chatroom) {
		// TODO Auto-generated method stub
		dao.saveChatroom(chatroom);
	}

	@Override
	public void updateChatroom(Chatroom chatroom) {
		// TODO Auto-generated method stub
		Chatroom entity = dao.findById(chatroom.getId());
		if(entity != null)
		{
			entity.setChatroomname(chatroom.getChatroomname());
			entity.setMaxUser(chatroom.getMaxUser());
		}
	}

	@Override
	public void deleteChatroomById(int id) {
		// TODO Auto-generated method stub
		dao.deleteChatroomById(id);
	}

	@Override
	public List<Chatroom> getAllChatrooms() {
		// WORKAROUND: The dao returns the chatrooms several times if multiple user have joined
		List<Chatroom> retList = new ArrayList<Chatroom>();
		for (Chatroom chatroom : dao.getAllChatrooms()) {
			boolean contains = false;
			for (Chatroom chatroom2 : retList) {
				if(chatroom2.getChatroomname() == chatroom.getChatroomname())
				{
					contains = true;
				}
			}
			if(!contains)
			{
				retList.add(chatroom);
			}
		}
		return retList;
	}

	@Override
	public Set<String> getAllCategories() {
		List<Chatroom> allChatrooms = getAllChatrooms();
		Set<String> retList = new HashSet<String>();
		for (Chatroom chatroom : allChatrooms) 
		{
			if(!retList.contains(chatroom.getCategory()))
			{
				retList.add(chatroom.getCategory());
			}
		}
		
		return retList;
	}

	@Override
	public boolean isUnique(String chatroomName) {
		// TODO Auto-generated method stub
		List<Chatroom> allChatrooms = getAllChatrooms();
		boolean retValue = true;
		for (Chatroom chatroom : allChatrooms) {
			if (chatroom.getChatroomname().equals(chatroomName))
			{
				retValue = false;
				break;
			}
		}
		return retValue;
	}

	@Override
	public boolean createNewChatroom(String chatroomName, int maxUser,	String category) {		
		// TODO Auto-generated method stub
		// abort if missing or illegel parameters
		if( (chatroomName == null) || (chatroomName == "") || (maxUser < 16) || (category == null) || (category == "") || !isUnique(chatroomName))
		{
			return false;
		}
		
		Chatroom tmpChatroom = new Chatroom();
		tmpChatroom.setChatroomname(chatroomName);
		tmpChatroom.setCategory(category);
		tmpChatroom.setMaxUser(maxUser);
		
		saveChatroom(tmpChatroom);
		
		return true;
	}

}
