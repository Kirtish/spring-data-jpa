package com.rsoft.app.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rsoft.app.domain.Purchase;
import com.rsoft.app.services.IPurchaseService;

@RestController
@RequestMapping(value="/api/rest/purchase")
public class PurchaseController {

	private IPurchaseService purchaseService; 
	
	@Autowired
	public PurchaseController(IPurchaseService purchaseService){
		this.purchaseService = purchaseService;
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Purchase> get(){
		return purchaseService.getPurchases();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Purchase getPurchase(@PathVariable Long id){
		return purchaseService.getPurchase(id);
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Purchase savPurchase(@RequestBody Purchase purchase){
		return purchaseService.savePurchase(purchase);
	}
	
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Purchase deletePurchase(@PathVariable Long id){
		return purchaseService.delePurchase(id);
	}
	
}
