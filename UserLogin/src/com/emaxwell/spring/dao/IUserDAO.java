package com.emaxwell.spring.dao;

import com.emaxwell.domain.User;

public interface IUserDAO {
	
	public User getUserByUserName(String userName);
	
	public User getUser(int userId);
	
	public void saveUser(User user);

}
