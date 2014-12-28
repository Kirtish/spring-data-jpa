package com.rsoft.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rsoft.app.domain.VocherCard;
import com.rsoft.app.services.IVocherCardService;

@RestController
@RequestMapping(value = "/api/rest/vocher")
public class VocherController {

	private IVocherCardService vocherCardService; 
	
	@Autowired
	public VocherController(IVocherCardService vocherCardService){
		this.vocherCardService = vocherCardService;
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<VocherCard> get(){
		return vocherCardService.getVocherCards();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody VocherCard getVocher(Long id){
		return vocherCardService.getVocherCard(id);
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody VocherCard saveVocher(VocherCard vocherCard){
		return vocherCardService.save(vocherCard);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody VocherCard deleteVocher(Long id){
		return vocherCardService.delete(id);
	}
}
