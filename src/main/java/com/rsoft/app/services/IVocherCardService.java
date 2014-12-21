package com.rsoft.app.services;

import java.util.List;

import com.rsoft.app.domain.VocherCard;

public interface IVocherCardService {

	public List<VocherCard> getVocherCards();
	
	public VocherCard getVocherCard(Long id);
	
	public VocherCard save(VocherCard vocherCard);
	
	public VocherCard delete(Long id);
}
