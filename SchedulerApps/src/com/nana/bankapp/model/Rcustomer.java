package com.nana.bankapp.model;

public class Rcustomer {

	private String customer_id;
	private String customer_name;
	private String email_address;

	public Rcustomer() {
	}

	public Rcustomer(String customer_id, String customer_name, String email_address) {
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.email_address = email_address;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

}
