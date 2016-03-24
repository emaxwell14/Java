package com.emaxwell.spring.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emaxwell.domain.User;
import com.emaxwell.spring.dao.IUserDAO;

/**
 * @Transactional means that session and transactions are handled by spring
 * Do not have to start or commit transactions or close session
 * 
 * @author User
 *
 */
@Service
public class UserDAOImpl implements IUserDAO{

	Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Get a user by its user name
	 */
	@Override
	public User getUserByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		User user = null;
		try{
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq(User.USERNAME, userName));
			user = (User) criteria.uniqueResult();
	     }catch (HibernateException e) {
	    	 log.error("Failed to set user by username. " + e);
	     } finally {
	     }
		return user;
	}
	
	/**
	 * Get a user by its id
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public User getUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		User user = null;
		try{
			user = (User) session.get(User.class, userId);
		} catch (HibernateException e){
			 log.error("Failed to set user by id. " + e);
		} finally {
	    }
		return user;
	}
	
	
	/**
	 * Add a user
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		try{
			session.saveOrUpdate(user);
		} catch (HibernateException e){
			 log.error("Failed to save user with id " + user.getId() + ". " + e);
		} finally {
	    }
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
