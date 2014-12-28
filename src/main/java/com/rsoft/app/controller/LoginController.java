package com.rsoft.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rsoft.app.services.IUserService;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	@Autowired
	private IUserService userService; 
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	
	public ModelAndView login(Model model,HttpServletRequest request){
		String username = request.getParameter("USERNAME");
		String password = request.getParameter("PASSWORD");
		return null;
	}
}
