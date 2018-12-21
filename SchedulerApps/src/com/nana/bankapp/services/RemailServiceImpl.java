package com.nana.bankapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nana.bankapp.dao.RemailDAO;
import com.nana.bankapp.model.Remail;

@Service
public class RemailServiceImpl implements RemailService{
	
	@Autowired
	RemailDAO remailDAO;
	
	@Override
	@Transactional
	public boolean saveRemail(Remail remail) {
		return remailDAO.saveRemail(remail);
	}
	
	@Override
	@Transactional
	public List<Remail> getRemail(){
		return remailDAO.getRemail();
	}
	
	@Override
	@Transactional
	public Remail getRemail(String getEmail_id) {
		return remailDAO.getRemail(getEmail_id);
	}
	
	@Override
	@Transactional
	public boolean deleteRemail(String getEmail_id) {
		return remailDAO.deleteRemail(getEmail_id);
	}

}
