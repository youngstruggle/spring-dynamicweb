package com.nana.bankapp.model;

public class Rdivision {
	
	private String division_id;
	private String division_name;

	public Rdivision() {
	}

	public Rdivision(String division_id, String division_name) {
		this.division_id = division_id;
		this.division_name = division_name;
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
