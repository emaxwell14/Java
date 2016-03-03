package com.emaxwell.spring.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
@Transactional
public class UserDAOImpl implements IUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public User getUserByUserName(String userName) {
		// TODO update to use objects
		Session session = sessionFactory.getCurrentSession();
		User user = null;
		try{
			user = (User) session.createQuery("FROM User where userName=?")
			.setParameter(0, userName)
			.uniqueResult();
	     }catch (HibernateException e) {
	         e.printStackTrace(); 
	      }finally {
	       //  session.close(); 
	      }
		return user;
/*	
		return (User) this.sessionFactory.getCurrentSession()
				.createQuery("FROM User where userName=?")
				.setParameter(0, userName)
				.uniqueResult();
*/
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
