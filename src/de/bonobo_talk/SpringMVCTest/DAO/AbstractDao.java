package de.bonobo_talk.SpringMVCTest.DAO;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
 
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * Template Class that handles the basics of transactions with the Database and takes care of the session 
 */
public abstract class AbstractDao<PK extends Serializable, T> {
     
    private final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @Autowired
    private SessionFactory sessionFactory;
 
    /*
     * returns the current session with the database
     */
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    @SuppressWarnings("unchecked")
    /*
     * returns the data by Primary Key
     */
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }
 
    /*
     * persists (saves) the entity in the database
     */
    public void persist(T entity) {
        getSession().persist(entity);
    }
 
    /*
     * deletes the entity in the database
     */
    public void delete(T entity) {
        getSession().delete(entity);
    }
    
    /*
     * updates or saves the entitiy in the databse
     */
    public void saveOrUpdate(T entity){
    	getSession().saveOrUpdate(entity);
    }
     
    /*
     * returns a criteria for sql queries
     */
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
 
}