package com.rsoft.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.rsoft.app.domain.SocialMediaService;
import com.rsoft.app.domain.User;
import com.rsoft.app.services.SecurityUtil;
import com.rsoft.app.services.UserService;

 
 
@Controller
@SessionAttributes("user")
public class RegistrationController {
 
    private UserService service;
 
    @Autowired
    public RegistrationController(UserService service) {
        this.service = service;
    }
 
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {

        Connection<?> connection = ProviderSignInUtils.getConnection(request);

        RegistrationForm registration = createRegistrationDTO(connection);

        model.addAttribute("user", registration);

        return "user/registration";
    }

    @RequestMapping(value ="/user/register", method = RequestMethod.POST)
    public String registerUserAccount(@Valid @ModelAttribute("user") RegistrationForm userAccountData,
                                      BindingResult result,
                                      WebRequest request) {
        if (result.hasErrors()) {
            return "user/registration";
        }
 
        User registered = createUserAccount(userAccountData, result);
 
        if (registered == null) {
            return "user/registration";
        }
        SecurityUtil.logInUser(registered);
        ProviderSignInUtils.handlePostSignUp(registered.getEmail(), request);
 
        return "redirect:/";
    }
 
    private User createUserAccount(RegistrationForm userAccountData, BindingResult result) {
        User registered = null;
 
        try {
            registered = service.registerNewUserAccount(userAccountData);
        }
        catch (Exception ex) {
            
        }
 
        return registered;
    }
 
    private void addFieldError(String objectName, String fieldName, String fieldValue,  String errorCode, BindingResult result) {
        FieldError error = new FieldError(
                objectName,
                fieldName,
                fieldValue,
                false,
                new String[]{errorCode},
                new Object[]{},
                errorCode
        );
 
        result.addError(error);
    }
    
    private RegistrationForm createRegistrationDTO(Connection<?> connection) {
        RegistrationForm dto = new RegistrationForm();

        if (connection != null) {
            UserProfile socialMediaProfile = connection.fetchUserProfile();
            dto.setEmail(socialMediaProfile.getEmail());
            dto.setFirstName(socialMediaProfile.getFirstName());
            dto.setLastName(socialMediaProfile.getLastName());

            ConnectionKey providerKey = connection.getKey();
            dto.setSignInProvider(SocialMediaService.valueOf(providerKey.getProviderId().toUpperCase()));
        }

        return dto;
    }
}
