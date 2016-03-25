package com.emaxwell.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	 @RequestMapping(value = "/accessDenied")
     public String accessDenied() {
           return "accessDenied";
      }
	 
	 @RequestMapping(value = "/sessionTimeout")
     public String sessionTimeout() {
           return "sessionTimeout";
      }

}
