package com.rsoft.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsoft.app.controller.RegistrationForm;
import com.rsoft.app.domain.SocialRole;
import com.rsoft.app.domain.User;
import com.rsoft.app.repositories.UserRepository;

 
@Service
public class RepositoryUserService implements UserService {
 
    private PasswordEncoder passwordEncoder;
 
    private UserRepository repository;
 
    @Autowired
    public RepositoryUserService(PasswordEncoder passwordEncoder, UserRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }
 
    @Transactional
    public User registerNewUserAccount(RegistrationForm userAccountData) throws Exception {
        if (emailExist(userAccountData.getEmail())) {
            throw new Exception("The email address: " + userAccountData.getEmail() + " is already in use.");
        }
 
        String encodedPassword = encodePassword(userAccountData);
 
        User user = new User();
        user.setFirstName(userAccountData.getFirstName());
        user.setLastName(userAccountData.getLastName());
        user.setEmail(userAccountData.getEmail());
        user.setPassword(encodedPassword);
		user.setRole(SocialRole.ROLE_USER);
        if (userAccountData.isSocialSignIn()) {
        	user.setSignInProvider(userAccountData.getSignInProvider());
        }     
        return repository.save(user);
    }
 
    private boolean emailExist(String email) {
        User user = repository.findByEmail(email);
 
        if (user != null) {
            return true;
        }
 
        return false;
    }
 
    private String encodePassword(RegistrationForm dto) {
        String encodedPassword = null;
 
        if (dto.isNormalRegistration()) {
            encodedPassword = passwordEncoder.encode(dto.getPassword());
        }
 
        return encodedPassword;
    }
}
