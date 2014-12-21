package com.rsoft.app.domain;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Purchase extends AbstractEntity {

	private String purchasedFrom; 
	
	private Date puchaseDate;
	
	private String comments; 
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="purchase_id",cascade = CascadeType.ALL )
	private Set<VocherTransaction> vochers = new HashSet<VocherTransaction>();

	public String getPurchasedFrom() {
		return purchasedFrom;
	}

	public void setPurchasedFrom(String purchasedFrom) {
		this.purchasedFrom = purchasedFrom;
	}

	public Date getPuchaseDate() {
		return puchaseDate;
	}

	public void setPuchaseDate(Date puchaseDate) {
		this.puchaseDate = puchaseDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Set<VocherTransaction> getVochers() {
		return vochers;
	}

	public void setVochers(Set<VocherTransaction> vochers) {
		this.vochers = vochers;
	}
			
	
			
}
