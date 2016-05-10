package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import de.bonobo_talk.SpringMVCTest.model.Chatroom;

@Repository("ChatroomDAO")
public class ChatroomDAOImpl extends AbstractDao<Integer, Chatroom> implements ChatroomDAO 
{

	@Override
	public Chatroom findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public void saveChatroom(Chatroom chatroom) {
		// TODO Auto-generated method stub
		persist(chatroom);
	}

	@Override
	public void deleteChatroomById(int id) {
		// TODO Auto-generated method stub
		//query to delete chatroom by ssn
        Query query = getSession().createSQLQuery("delete from Chatroom where id = :id");
        //replaces :id with the givenvalue
        query.setString(id, Integer.toString(id));
        //executes the sql query
        query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Chatroom> getAllChatrooms() {
		// TODO Auto-generated method stub
		//creates criteria to select all chatroom objects
		Criteria criteria = getSession().createCriteria(Chatroom.class);
		//executes the criteria
        return (List<Chatroom>) criteria.list();
	}

}
