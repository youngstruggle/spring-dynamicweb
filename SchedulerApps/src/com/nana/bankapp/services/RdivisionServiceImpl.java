package com.nana.bankapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nana.bankapp.dao.RdivisionDAO;
import com.nana.bankapp.model.Rdivision;

@Service
public class RdivisionServiceImpl implements RdivisionService {

	@Autowired
	RdivisionDAO rdivisionDAO;

	@Override
	@Transactional
	public boolean saveRdivision(Rdivision rdivision) {
		return rdivisionDAO.saveRdivision(rdivision);
	}

	@Override
	@Transactional
	public List<Rdivision> getRdivision() {
		return rdivisionDAO.getRdivision();
	}

	@Override
	@Transactional
	public Rdivision getRdivision(String division_id) {
		return rdivisionDAO.getRdivision(division_id);
	}

	@Override
	@Transactional
	public boolean deleteRdivision(String division_id) {
		return rdivisionDAO.deleteRdivision(division_id);
	}

}
