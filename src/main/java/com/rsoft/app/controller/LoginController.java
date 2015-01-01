package com.rsoft.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "user/login";
    }
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLandingPage(HttpServletRequest request,Authentication authentication,Model model) {
        return "index";
    }
}
