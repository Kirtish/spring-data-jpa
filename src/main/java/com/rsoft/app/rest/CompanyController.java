package com.rsoft.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rsoft.app.domain.Company;
import com.rsoft.app.services.ICompanyService;

@RestController
@RequestMapping(value = "/api/rest/company")
public class CompanyController {

	private ICompanyService companyService;

	@Autowired
	public CompanyController(ICompanyService companyService) {
		this.companyService = companyService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Company getCompany(@PathVariable Long id) {
		return companyService.getCompany(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Company> get() {
		return companyService.getCompanies();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Company save(@RequestBody Company company) {
		return companyService.save(company);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Company deleteCompany(@PathVariable Long id) {
		return companyService.delete(id);
	}

}
