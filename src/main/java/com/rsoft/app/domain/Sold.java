package com.rsoft.app.domain;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Sold extends AbstractEntity{

	private String soldTo; 
	
	private Date soldDate; 
	
	private String address; 

	@OneToMany(fetch=FetchType.LAZY , mappedBy = "sold_id")
	private Set<VocherTransaction> vochers = new HashSet<VocherTransaction>(); 
	
	public String getSoldTo() {
		return soldTo;
	}

	public void setSoldTo(String soldTo) {
		this.soldTo = soldTo;
	}

	public Date getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<VocherTransaction> getVochers() {
		return vochers;
	}

	public void setVochers(Set<VocherTransaction> vochers) {
		this.vochers = vochers;
	}}
