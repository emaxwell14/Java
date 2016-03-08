package com.emaxwell.spring.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emaxwell.domain.User;
import com.emaxwell.spring.dao.IUserDAO;
import com.emaxwell.spring.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDAO userDAO;

	@Override
	@Transactional
	public User getUserByUserName(String userName) {
		return userDAO.getUserByUserName(userName);
	}
	
	@Override
	@Transactional
	public User getUser(int userId) {
		return userDAO.getUser(userId);
	}

	@Override
	@Transactional
	public int saveUser(User user) {
		return userDAO.saveUser(user);
	}

}
