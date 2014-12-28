package com.rsoft.app.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rsoft.app.domain.Role;
import com.rsoft.app.services.IRoleService;

@Controller
@RequestMapping(value = "/roles")
public class RoleController {

	private IRoleService roleService;

	@Autowired
	public RoleController(IRoleService roleService) {
		this.roleService = roleService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get() {
		ModelAndView modelAndView = new ModelAndView(DEFAULT_VIEW);
		modelAndView.addObject("roles", roleService.getRoles());
		return modelAndView;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView addRole() {
		ModelAndView modelAndView = new ModelAndView(ADD_VIEW);
		modelAndView.addObject("role", new Role());
		return modelAndView;
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editRole(@PathVariable String id, ModelMap model) {
		model.put("role", roleService.getRole(Long.parseLong(id)));
		return EDIT_VIEW;
	}
	
	@RequestMapping(value="/new",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("role") Role role,
			BindingResult result, ModelMap model){
		role.setDeleted(false);
		role.setLastUpdatedBy(1L);
		java.util.Date today = new java.util.Date();
		role.setLastUpdatedtm(new Timestamp(today.getTime()));
		roleService.save(role);
		ModelAndView viewSuccess = new ModelAndView(DEFAULT_VIEW);
		viewSuccess.addObject("roles", roleService.getRoles());
		return viewSuccess;
	}
	
	@RequestMapping(value="/{id}/edit/",method = RequestMethod.PUT)
	public ModelAndView update(@ModelAttribute("role") Role role,
			BindingResult result, ModelMap model){
		role.setLastUpdatedBy(1L);
		java.util.Date today = new java.util.Date();
		role.setLastUpdatedtm(new Timestamp(today.getTime()));
		roleService.save(role);
		ModelAndView viewSuccess = new ModelAndView(DEFAULT_VIEW);
		viewSuccess.addObject("roles", roleService.getRoles());
		return viewSuccess;
	}

	private static String DEFAULT_VIEW = "/role/allRoles";
	private static String ADD_VIEW = "/role/addRole";
	private static String EDIT_VIEW = "/role/editRole";

}
