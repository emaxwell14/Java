package com.emaxwell.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emaxwell.domain.Role;
import com.emaxwell.spring.dao.IRoleDAO;
import com.emaxwell.spring.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDAO roleDAO;
	
	@Override
	@Transactional
	public List<Role> getAllRoles() {
		return roleDAO.getAllRoles();
	}

}
