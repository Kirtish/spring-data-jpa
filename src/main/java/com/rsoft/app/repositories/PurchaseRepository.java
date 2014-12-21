package com.rsoft.app.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rsoft.app.domain.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Long>{

	public List<Purchase> getPurchaseByPuchaseDate(Date puchaseDate);
}
