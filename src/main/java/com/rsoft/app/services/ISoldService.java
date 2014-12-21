package com.rsoft.app.services;

import java.util.Date;
import java.util.List;

import com.rsoft.app.domain.Sold;

public interface ISoldService {

	public List<Sold> getSolds();
	
	public Sold getSold(Long id);
	
	public Sold saveSold(Sold sold);
	
	public Sold deleteSold(Long id);
	
	public List<Sold> fetchBySoldDate(Date soldDate);
}
