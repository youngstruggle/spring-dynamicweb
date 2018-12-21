package com.nana.bankapp.services;

import java.util.List;

import com.nana.bankapp.model.Rcustomer;

public interface RcustomerService {

	public boolean saveRcustomer(Rcustomer rcustomer);
	public List<Rcustomer> getRcustomers();
	public Rcustomer getRcustomer(String customer_id);
	public boolean deleteRcustomer(String customer_id);

}