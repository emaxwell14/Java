package com.emaxwell.spring.service;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emaxwell.domain.User;

/**
 * @Transactional means that session and transactions are handled by spring
 * Do not have to start or commit transactions or close session
 * 
 * @author User
 *
 */
@Service

public class UserDAOImpl implements IUserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Get a user by its user name
	 */
	@Transactional
	public User getUserByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		User user = null;
		try{
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq(User.USERNAME, userName));
			user = (User) criteria.uniqueResult();
	     }catch (HibernateException e) {
	         e.printStackTrace(); 
	     }
		return user;
	}
	
	/**
	 * Get a user by its id
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional
	public User getUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		User user = null;
		try{
			user = (User) session.get(User.class, userId);
		} catch (HibernateException e){
			e.printStackTrace(); 
		}
		return user;
	}
	
	
	/**
	 * Add a user
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional
	public int saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		int userId = 0;
		try{
			userId = (Integer) session.save(user);
		} catch (HibernateException e){
			e.printStackTrace(); 
		}
		return userId;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
