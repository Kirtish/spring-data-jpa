package com.rsoft.app.services;

import java.util.List;

import com.rsoft.app.domain.User;

public interface IUserService {

	public List<User> getUsers();
	
	public User getUser(Long id);
	
	public User save(User user);
	
	public User delete(Long id);
}
