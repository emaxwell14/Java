package com.emaxwell.spring.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emaxwell.domain.Role;
import com.emaxwell.spring.dao.IRoleDAO;

@Service
public class RoleDAOImpl implements IRoleDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	Log log = LogFactory.getLog(this.getClass());
	
	@Override
	public List<Role> getAllRoles() {
		Session session = sessionFactory.getCurrentSession();
		List<Role> roles = null;
		try{
			roles = session.createCriteria(Role.class).list();
		} catch (HibernateException e){
			 log.error("Failed to get all roles");
		} finally {
	    }
		return roles;
	}
}
