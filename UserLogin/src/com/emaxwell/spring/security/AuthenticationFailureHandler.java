package com.emaxwell.spring.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component("authenticationFailureHandler")
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
	//	response.setStatus(HttpStatus.UNAUTHORIZED.value());
		PrintWriter out = response.getWriter();
/*		
		if (exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
			out.write("logon.error.password.mismatch");
		} else if (exception.getClass().isAssignableFrom(DisabledException.class)) {
			out.write("logon.error.user.inactive");
		} else if (exception.getClass().isAssignableFrom(LockedException.class)) {
			out.write("logon.error.user.emailNotAuthenticated");
		} else if (exception.getClass().isAssignableFrom(InternalAuthenticationServiceException.class)) {
			out.write("logon.error.user.nonExistent");
		}
*/	
	}
}
