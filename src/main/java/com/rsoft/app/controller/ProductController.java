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
import com.rsoft.app.domain.VocherCard;
import com.rsoft.app.services.ICompanyService;
import com.rsoft.app.services.IVocherCardService;

@Controller
@RequestMapping(value="/products")
public class ProductController {

	private static String ADD_VIEW = "/products/addProduct";
	private static String EDIT_VIEW = "/products/editProduct";
	private static String DEFAULT_VIEW = "/products/allProducts";

	private ICompanyService companyService;
	private IVocherCardService vocherCardService;

	@Autowired
	public ProductController(ICompanyService companyService,
			IVocherCardService vocherCardService) {
		this.companyService = companyService;
		this.vocherCardService = vocherCardService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get() {
		ModelAndView modelAndView = new ModelAndView(DEFAULT_VIEW);
		modelAndView.addObject("products", vocherCardService.getVocherCards());
		return modelAndView;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView addCompany() {
		ModelAndView modelAndView = new ModelAndView(ADD_VIEW);
		modelAndView.addObject("product", new VocherCard());
		modelAndView.addObject("companies",companyService.getCompanies());
		return modelAndView;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("product") VocherCard vocherCard,
			BindingResult result, ModelMap model) {
		vocherCard.setDeleted(false);
		vocherCard.setLastUpdatedBy(1L);
		java.util.Date today = new java.util.Date();
		vocherCard.setLastUpdatedtm(new Timestamp(today.getTime()));
		vocherCardService.save(vocherCard);
		ModelAndView viewSuccess = new ModelAndView(DEFAULT_VIEW);
		viewSuccess.addObject("products", vocherCardService.getVocherCards());
		return viewSuccess;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCompany(@PathVariable String id, ModelMap model) {
		model.put("product", vocherCardService.getVocherCard(Long.parseLong(id)));
		model.put("companies",companyService.getCompanies());
		return EDIT_VIEW;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public ModelAndView update(@ModelAttribute("company") Company company,
			BindingResult result, ModelMap model) {
		company.setLastUpdatedBy(1L);
		java.util.Date today = new java.util.Date();
		company.setLastUpdatedtm(new Timestamp(today.getTime()));
		companyService.save(company);
		ModelAndView viewSuccess = new ModelAndView(DEFAULT_VIEW);
		viewSuccess.addObject("products", vocherCardService.getVocherCards());
		return viewSuccess;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id, ModelMap model) {
		vocherCardService.delete(Long.parseLong(id));
		model.addAttribute("products", vocherCardService.getVocherCards());
		return DEFAULT_VIEW;
	}
}
