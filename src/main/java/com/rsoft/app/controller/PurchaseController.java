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

import com.rsoft.app.domain.Purchase;
import com.rsoft.app.domain.VocherTransaction;
import com.rsoft.app.services.ICompanyService;
import com.rsoft.app.services.IPurchaseService;
import com.rsoft.app.services.IVocherCardService;

@Controller
@RequestMapping(value = "/purchases")
public class PurchaseController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get() {
		ModelAndView modelAndView = new ModelAndView(DEFAULT_VIEW);
		modelAndView.addObject("purchases", purchaseService.getPurchases());
		return modelAndView;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView addCompany() {
		ModelAndView modelAndView = new ModelAndView(ADD_VIEW);
		Purchase purchase = new Purchase();
		purchase.getVochers().add(new VocherTransaction());
		modelAndView.addObject("purchase", purchase );
		modelAndView.addObject("companies" , companyService.getCompanies());
		modelAndView.addObject("products",vocherCardService.getVocherCards());
		return modelAndView;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("purchase") Purchase purchase,
			BindingResult result, ModelMap model) {
		purchase.setDeleted(false);
		purchase.setLastUpdatedBy(1L);
		java.util.Date today = new java.util.Date();
		purchase.setLastUpdatedtm(new Timestamp(today.getTime()));
		purchaseService.savePurchase(purchase);		
		ModelAndView viewSuccess = new ModelAndView(DEFAULT_VIEW);
		viewSuccess.addObject("purchases", purchaseService.getPurchases());
		return viewSuccess;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCompany(@PathVariable String id, ModelMap model) {
		model.put("purchase", purchaseService.getPurchase(Long.parseLong(id)));
		model.put("companies" , companyService.getCompanies());
		model.put("products",vocherCardService.getVocherCards());
		return EDIT_VIEW;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public ModelAndView update(@ModelAttribute("purchase") Purchase purchase,
			BindingResult result, ModelMap model) {
		purchase.setLastUpdatedBy(1L);
		java.util.Date today = new java.util.Date();
		purchase.setLastUpdatedtm(new Timestamp(today.getTime()));
		purchaseService.updatePurchase(purchase);
		ModelAndView viewSuccess = new ModelAndView(DEFAULT_VIEW);
		viewSuccess.addObject("purchases", purchaseService.getPurchases());
		return viewSuccess;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id, ModelMap model) {
		purchaseService.delePurchase(Long.parseLong(id));
		model.addAttribute("purchases", purchaseService.getPurchases());
		return DEFAULT_VIEW;
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String add(@ModelAttribute("purchase") Purchase purchase ,ModelAndView model) {
		ModelAndView modelAndView = new ModelAndView(ADD_VIEW);
		purchase.getVochers().add(new VocherTransaction());
		modelAndView.addObject("purchase", purchase );
/*		modelAndView.addObject("companies" , companyService.getCompanies());
		modelAndView.addObject("products",vocherCardService.getVocherCards());
*/		return ADD_VIEW;
	}
	@RequestMapping(value = "/removeProduct/{index}", method = RequestMethod.GET)
	public String remove(@PathVariable int index,@ModelAttribute("purchase") Purchase purchase ,ModelAndView model) {
		ModelAndView modelAndView = new ModelAndView(ADD_VIEW);
		purchase.getVochers().remove(index);
		modelAndView.addObject("purchase", purchase );
/*		modelAndView.addObject("companies" , companyService.getCompanies());
		modelAndView.addObject("products",vocherCardService.getVocherCards());
*/		return ADD_VIEW;
	}
	
	@Autowired
	public PurchaseController(IPurchaseService purchaseService,IVocherCardService vocherCardService
			,ICompanyService companyService){
		this.companyService = companyService;
		this.purchaseService = purchaseService;
		this.vocherCardService = vocherCardService;
	}

	private static String ADD_VIEW = "/purchase/addPurchase";
	private static String EDIT_VIEW = "/purchase/editPurchase";
	private static String DEFAULT_VIEW = "/purchase/allPurchases";

	private IPurchaseService purchaseService;

	private IVocherCardService vocherCardService;
	
	private ICompanyService companyService;


	
}
