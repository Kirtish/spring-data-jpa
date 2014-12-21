package com.rsoft.app.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsoft.app.domain.Company;
import com.rsoft.app.repositories.CompanyRepository;
import com.rsoft.app.services.ICompanyService;

@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<Company> getCompanies() {
		List<Company> companies = new ArrayList<Company>();
		Iterator<Company> itr = companyRepository.findAll().iterator();
		while (itr.hasNext())
			companies.add(itr.next());
		return companies;
	}

	@Override
	public Company getCompany(Long id) {
		return companyRepository.findOne(id);
	}

	@Transactional
	@Override
	public Company save(Company company) {
		return companyRepository.save(company);
	}

	@Transactional
	@Override
	public Company delete(Long id) {
		Company comp = getCompany(id);
		companyRepository.delete(comp);
		return comp;
	}

}
