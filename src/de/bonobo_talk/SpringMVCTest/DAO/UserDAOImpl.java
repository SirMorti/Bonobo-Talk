package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import de.bonobo_talk.SpringMVCTest.model.User;
 

 
@Repository("UserDAO")
public class UserDAOImpl extends AbstractDao<Integer, User> implements UserDAO {
 
    public User findById(int id) {
        return getByKey(id);
    }
 
    public void deleteUser(String username) {
        Query query = getSession().createSQLQuery("delete from User where username = :username");
        query.setString("username", username);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<User> getAllUser() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }
 
    public User findUserByUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }

	@Override
	public void saveOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		saveOrUpdate(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
        Query query = getSession().createSQLQuery("delete from User where id = :id");
        query.setString("id", Integer.toString(id));
        query.executeUpdate();
	}
}
