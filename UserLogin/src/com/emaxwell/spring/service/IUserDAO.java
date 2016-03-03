package com.emaxwell.spring.service;

import com.emaxwell.domain.User;

public interface IUserDAO {
	
	public User getUserByUserName(String userName);
	
	public User getUser(int userId);
	
	public int saveUser(User user);

}
