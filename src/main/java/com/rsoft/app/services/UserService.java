package com.rsoft.app.services;

import com.rsoft.app.controller.RegistrationForm;
import com.rsoft.app.domain.User;

public interface UserService {

	public User registerNewUserAccount(RegistrationForm userAccountData) throws Exception;
}
