package com.rsoft.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rsoft.app.domain.User;
import com.rsoft.app.repositories.UserRepository;
import com.rsoft.app.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findOne(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public User delete(Long id) {
		User user = getUser(id);
		userRepository.delete(user);
		return user;
	}

}
