package com.nana.bankapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rdivision")
public class RdivisionEntity {
	
	@Id
	@Column(name = "division_id")
	private String division_id;
	
	@Column(name = "division_name")
	private String division_name;

	public RdivisionEntity() {
	}

	public String getDivision_id() {
		return division_id;
	}

	public void setDivision_id(String division_id) {
		this.division_id = division_id;
	}

	public String getDivision_name() {
		return division_name;
	}

	public void setDivision_name(String division_name) {
		this.division_name = division_name;
	}

}
