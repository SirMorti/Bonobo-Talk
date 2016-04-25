package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.User;

public interface UserDAO {
	User findById(int id);
    void saveOrUpdateUser(User user);  
    void deleteUser(String username);
    void deleteUser(int id);
    List<User> getAllUser();
    User findUserByUsername(String username);
}
 