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
	public void deleteChatroomBySsn(String ssn) {
		// TODO Auto-generated method stub
        Query query = getSession().createSQLQuery("delete from Chatroom where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Chatroom> getAllChatrooms() {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
        return (List<Chatroom>) criteria.list();
	}

	@Override
	public Chatroom findChatroomBySsn(String ssn) {
		// TODO Auto-generated method stub
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Chatroom) criteria.uniqueResult();
	}

}
