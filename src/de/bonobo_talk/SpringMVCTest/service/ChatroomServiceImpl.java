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
			entity.setSsn(chatroom.getSsn());
		}
	}

	@Override
	public void deleteChatroomBySsn(String ssn) {
		// TODO Auto-generated method stub
		dao.deleteChatroomBySsn(ssn);
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
	public Chatroom findChatroomBySsn(String ssn) {
		// TODO Auto-generated method stub
		return dao.findChatroomBySsn(ssn);
	}

	@Override
	public boolean isChatroomSsnUnique(Integer id, String ssn) {
		// TODO Auto-generated method stub
		Chatroom chatroom = findChatroomBySsn(ssn);
		return (chatroom == null || ((id != null) && (chatroom.getId() == id)));
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

}
