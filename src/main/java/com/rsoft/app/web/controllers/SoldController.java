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

import com.rsoft.app.domain.Sold;
import com.rsoft.app.services.ISoldService;

@RestController
@RequestMapping(value = "/api/rest/sold")
public class SoldController {

	private ISoldService soldService;

	@Autowired
	public SoldController(ISoldService soldService) {
		this.soldService = soldService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Sold> get() {
		return soldService.getSolds();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Sold getSold(@PathVariable Long id) {
		return soldService.getSold(id);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Sold saveSold(@RequestBody Sold sold) {
		return soldService.saveSold(sold);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Sold deleteSold(Long id) {
		return soldService.deleteSold(id);
	}
}
