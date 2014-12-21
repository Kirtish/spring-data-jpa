package com.rsoft.app.services;

import java.util.List;

import com.rsoft.app.domain.Company;

public interface ICompanyService {

	public List<Company> getCompanies();
	
	public Company getCompany(Long id);
	
	public Company save(Company company);
	
	public Company delete(Long id);
}
