package com.emaxwell.spring.service;

import com.emaxwell.domain.User;


public interface IUserService {
	public User getUserByUserName(String userName);
	
	public User getUser(int userId);
	
	public void saveUser(User user);
}
