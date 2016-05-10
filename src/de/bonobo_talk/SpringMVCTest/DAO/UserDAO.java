package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.User;

public interface UserDAO {
	/*
	 * returns the user by id 
	 * if no user with a matching id could be found null will returned
	 */
	User findById(int id);
	/*
	 * saves a new user and updates an existing one
	 */
    void saveOrUpdateUser(User user);
    /*
     * deletes user by username
     */
    void deleteUser(String username);
    /*
     * deletes user by id
     */
    void deleteUser(int id);
    /*
     * returns all users 
     */
    List<User> getAllUser();
    /*
     * returns the user with the matching username
     * if no user can be found will return null
     */
    User findUserByUsername(String username);
}
 