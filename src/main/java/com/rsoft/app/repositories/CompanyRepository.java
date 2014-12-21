package com.rsoft.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rsoft.app.domain.Company;

public interface CompanyRepository extends CrudRepository<Company, Long>{

}
