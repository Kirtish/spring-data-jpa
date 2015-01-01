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

import com.rsoft.app.domain.Company;
import com.rsoft.app.services.ICompanyService;

@Controller
@RequestMapping(value = "/company/")
public class CompanyController {

	private static String ADD_VIEW = "/company/addCompany";
	private static String EDIT_VIEW = "/company/editCompany";
	private static String DEFAULT_VIEW = "/company/allCompanies";
	private ICompanyService companyService; 
	
	
	@Autowired
	public CompanyController(ICompanyService companyService){
		this.companyService = companyService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get() {
		ModelAndView modelAndView = new ModelAndView(DEFAULT_VIEW);
		modelAndView.addObject("companies", companyService.getCompanies());
		return modelAndView;
	} 
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView addCompany() {
		ModelAndView modelAndView = new ModelAndView(ADD_VIEW);
		modelAndView.addObject("company", new Company());
		return modelAndView;
	}
	
	@RequestMapping(value="/new",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("company") Company company,
			BindingResult result, ModelMap model){
		company.setDeleted(false);
		company.setLastUpdatedBy(1L);
		java.util.Date today = new java.util.Date();
		company.setLastUpdatedtm(new Timestamp(today.getTime()));
		companyService.save(company);
		ModelAndView viewSuccess = new ModelAndView(DEFAULT_VIEW);
		viewSuccess.addObject("companies", companyService.getCompanies());
		return viewSuccess;
	}
	
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCompany(@PathVariable String id, ModelMap model) {
		model.put("company", companyService.getCompany(Long.parseLong(id)));
		return EDIT_VIEW;
	}
	
	@RequestMapping(value="/edit/{id}",method = RequestMethod.PUT)
	public ModelAndView update(@ModelAttribute("company") Company company,
			BindingResult result, ModelMap model){
		company.setLastUpdatedBy(1L);
		java.util.Date today = new java.util.Date();
		company.setLastUpdatedtm(new Timestamp(today.getTime()));
		companyService.save(company);
		ModelAndView viewSuccess = new ModelAndView(DEFAULT_VIEW);
		viewSuccess.addObject("companies", companyService.getCompanies());
		return viewSuccess; 
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id, ModelMap model) {
		 companyService.delete(Long.parseLong(id));
		model.addAttribute("companies", companyService.getCompanies());
		return DEFAULT_VIEW; 
	}
	
	
}

