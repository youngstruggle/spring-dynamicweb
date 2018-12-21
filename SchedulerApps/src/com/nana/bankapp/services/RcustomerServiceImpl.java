package com.nana.bankapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nana.bankapp.dao.RcustomerDAO;
import com.nana.bankapp.model.Rcustomer;

@Service
public class RcustomerServiceImpl implements RcustomerService {

	@Autowired
	RcustomerDAO rcustomerDAO;

	@Override
	@Transactional
	public boolean saveRcustomer(Rcustomer rcustomer) {
		return rcustomerDAO.saveRcustomer(rcustomer);
	}

	@Override
	@Transactional
	public List<Rcustomer> getRcustomers() {
		return rcustomerDAO.getRcustomers();
	}

	@Override
	@Transactional
	public Rcustomer getRcustomer(String customer_id) {
		return rcustomerDAO.getRcustomer(customer_id);
	}
	
	@Override
	@Transactional
	public boolean deleteRcustomer(String customer_id) {
		return rcustomerDAO.deleteRcustomer(customer_id);
	}

}
