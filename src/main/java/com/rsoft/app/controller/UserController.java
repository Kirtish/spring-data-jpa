package com.rsoft.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rsoft.app.services.IUserService;

@Controller
@RequestMapping(value="/users/")
public class UserController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get(){
		ModelAndView modelAndView = new ModelAndView(VIEW);
		modelAndView.addObject("allusers",getUserService().getUsers());
		return modelAndView;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Autowired
	private IUserService userService; 

	private static final String VIEW = "/user/allusers";
	
}
