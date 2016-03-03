package com.emaxwell.spring.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emaxwell.spring.service.IUserDAO;
import com.emaxwell.spring.service.UserDAOImpl;

//@Transactional(readOnly=true)
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	public IUserDAO userService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
/*
		if (account == null) {
			throw new UsernameNotFoundException("No such user: " + username);
		} else if (account.getRoles().isEmpty()) {
			throw new UsernameNotFoundException("User " + username + " has no authorities");
		}
*/
		// Get user from db
		com.emaxwell.domain.User user  = userService.getUserByUserName(userName);
		
		// Get roles
		Collection<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		String role = "ROLE_USER";
		roles.add(new SimpleGrantedAuthority(role));
		
		return new User(user.getUserName(), user.getPassword(), roles);
	}
/*
	public List<String> getRolesAsList(Set<Role> roles) {
		List<String> rolesAsList = new ArrayList<String>();
		for (Role role : roles) {
			rolesAsList.add(role.getName());
		}
		return rolesAsList;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRolesAsList(roles));
		return authList;
	}
*/

}