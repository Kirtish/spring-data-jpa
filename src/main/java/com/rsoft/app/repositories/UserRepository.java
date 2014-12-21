package com.rsoft.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rsoft.app.domain.User;


public interface UserRepository extends CrudRepository<User, Long>{

	public User findByLoginIdAndPwd(String loginId,String pwd);
}
