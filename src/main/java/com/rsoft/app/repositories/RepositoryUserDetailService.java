package com.rsoft.app.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rsoft.app.domain.User;
import com.rsoft.app.model.UserDetails;

public class RepositoryUserDetailService implements UserDetailsService {

	private UserRepository repository;
	 
    @Autowired
    public RepositoryUserDetailService(UserRepository repository) {
        this.repository = repository;
    }
 
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {
        User user = repository.findByEmail(username);
 
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }
 
        UserDetails principal = UserDetails.getBuilder()
                .firstName(user.getFirstName())
                .id(user.getId())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .role(user.getRole())
                .socialSignInProvider(user.getSignInProvider())
                .username(user.getEmail())
                .build();
 
        return principal;
    }

}
