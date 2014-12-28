package com.rsoft.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rsoft.app.domain.User;
import com.rsoft.app.services.IUserService;

@RestController
@RequestMapping("/rest/api/user")
public class UserController {

	@Autowired
	private IUserService userService; 
	
	@Autowired
	public UserController(IUserService userRepository){
		this.userService = userService;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User get(@PathVariable Long id){
		return userService.getUser(id);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Long id){
		userService.delete(id);
	}
	
	@RequestMapping(value="/save",method =RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User save(@RequestBody User user){
		return userService.save(user);
	}
	
	@RequestMapping(value="/",method =RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User>get(){
		return userService.getUsers();
	}
	
}
