package com.emaxwell.spring.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.emaxwell.domain.Role;
import com.emaxwell.domain.User;
import com.emaxwell.spring.controller.dto.UserDTO;
import com.emaxwell.spring.service.IRoleService;
import com.emaxwell.spring.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value = { "/addUser" }, method = RequestMethod.GET)
	public ModelAndView addUserPage(User user) {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		
		List<Role> roleList = roleService.getAllRoles();
		model.addObject("roleList", roleList);
		model.setViewName("addUser");
		return model;
	}
	
	
	@RequestMapping(value = { "/addUserSubmit" }, method = RequestMethod.POST)
	public String addUserSubmit(@ModelAttribute("userDto") UserDTO userDto) {
		
		User user = populateUserObject(userDto);
		
		userService.saveUser(user);
		return "userCreated";
	}
	
	private User populateUserObject(UserDTO userDto){
		User user = new User();
		
		user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		
		Set<Role> roles = new HashSet<Role>();
		Role currentRole = null;
		for (Integer roleId  : userDto.getRoleIds()){
			currentRole = new Role(roleId);
			roles.add(currentRole);
		}
		user.setRoles(roles);
		
		return user;
	}
	
	@ModelAttribute("userDto")
	public UserDTO getUserForm() {
		UserDTO userDto = new UserDTO();
	    return userDto;
	}
	
}
