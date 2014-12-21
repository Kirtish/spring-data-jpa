package com.rsoft.app.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsoft.app.domain.Sold;
import com.rsoft.app.repositories.SoldRepository;
import com.rsoft.app.services.ISoldService;

@Service
public class SoldServiceImpl implements ISoldService {

	private SoldRepository soldRepository;

	@Override
	public List<Sold> getSolds() {
		List<Sold> solds = new ArrayList<Sold>();
		Iterator<Sold> itr = soldRepository.findAll().iterator();
		while(itr.hasNext())
			solds.add(itr.next());
		return solds;
	}

	@Override
	public Sold getSold(Long id) {
		return soldRepository.findOne(id);
	}

	@Transactional
	@Override
	public Sold saveSold(Sold sold) {
		return soldRepository.save(sold);
	}

	@Transactional
	@Override
	public Sold deleteSold(Long id) {
		Sold sold = getSold(id);
		soldRepository.delete(sold);
		return sold;
	}

	@Override
	public List<Sold> fetchBySoldDate(Date soldDate) {

		return null;
	}

}
