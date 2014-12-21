package com.rsoft.app.services;

import java.util.List;

import com.rsoft.app.domain.Role;

public interface IRoleService {
	
	public List<Role> getRoles();
	
	public Role getRole(Long id);
	
	public Role save(Role role);
	
	public Role delete(Long id);

}
