package com.rsoft.app.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class VocherCard extends AbstractEntity{

	private String name; 
	
	private String descr; 
	
    private boolean topup; 
    
    private BigDecimal price;
    
    private BigDecimal instock; 
    
    private BigDecimal minStock; 
    
    private BigDecimal maxStock;
    
    @ManyToOne
    private Company company; 
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public boolean isTopup() {
		return topup;
	}

	public void setTopup(boolean topup) {
		this.topup = topup;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getInstock() {
		return instock;
	}

	public void setInstock(BigDecimal instock) {
		this.instock = instock;
	}

	public BigDecimal getMinStock() {
		return minStock;
	}

	public void setMinStock(BigDecimal minStock) {
		this.minStock = minStock;
	}

	public BigDecimal getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(BigDecimal maxStock) {
		this.maxStock = maxStock;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
    
}
