package com.emaxwell.spring.service;

import com.emaxwell.domain.User;

public interface IUserDAO {
	
	public User getUserByUserName(String userName);

}
