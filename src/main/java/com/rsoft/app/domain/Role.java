package com.rsoft.app.domain;

import javax.persistence.Column;

import javax.persistence.Entity;

@Entity
public class Role extends AbstractEntity{

	@Column(nullable = false)
	private String descr; 
	
	@Column(nullable = false)
	private String code;

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	} 
	
	
	
}
