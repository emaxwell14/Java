package com.emaxwell.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emaxwell.domain.User;
import com.emaxwell.spring.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = { "/addUser" }, method = RequestMethod.GET)
	public String addUserPage(@ModelAttribute("user") User user) {
		return "addUser";
	}
	
	
	@RequestMapping(value = { "/addUserSubmit" }, method = RequestMethod.POST)
	public String addUserSubmit(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "userCreated";
	}
	
}
