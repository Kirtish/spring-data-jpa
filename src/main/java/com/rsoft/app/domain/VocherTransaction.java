package com.rsoft.app.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class VocherTransaction extends AbstractEntity{

	private String type; 
	
	private VocherCard vocher; 
	
	private Long purchase_id; 
	
	private Long sold_id ; 
	
	private BigDecimal quantity; 
	
	private String vocherStartNo; 
	
	private String vocherEndNo;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public VocherCard getVocher() {
		return vocher;
	}

	public void setVocher(VocherCard vocher) {
		this.vocher = vocher;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getVocherStartNo() {
		return vocherStartNo;
	}

	public void setVocherStartNo(String vocherStartNo) {
		this.vocherStartNo = vocherStartNo;
	}

	public String getVocherEndNo() {
		return vocherEndNo;
	}

	public void setVocherEndNo(String vocherEndNo) {
		this.vocherEndNo = vocherEndNo;
	}

	public Long getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(Long purchase_id) {
		this.purchase_id = purchase_id;
	}

	public Long getSold_id() {
		return sold_id;
	}

	public void setSold_id(Long sold_id) {
		this.sold_id = sold_id;
	} 
	
	
	
}
