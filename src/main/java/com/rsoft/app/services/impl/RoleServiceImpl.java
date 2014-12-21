package com.rsoft.app.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rsoft.app.domain.Role;
import com.rsoft.app.repositories.RoleRepository;
import com.rsoft.app.services.IRoleService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RoleServiceImpl implements IRoleService{

	@Autowired
	RoleRepository roleRepository; 
		
	
	@Override
	public List<Role> getRoles() {
		List<Role> roles = new ArrayList<Role>();
		Iterator<Role> itr = roleRepository.findAll().iterator();
		while(itr.hasNext())
			roles.add(itr.next());			
		return roles;
	}

	@Override
	public Role getRole(Long id) {
		return roleRepository.findOne(id);
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role delete(Long id) {
		Role role = getRole(id);
		roleRepository.delete(id);
		return role;
	}

}
