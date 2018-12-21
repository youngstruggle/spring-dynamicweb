package com.nana.bankapp.services;

import java.util.List;

import com.nana.bankapp.model.Rdivision;

public interface RdivisionService {

	public boolean saveRdivision(Rdivision rdivision);
	public List<Rdivision> getRdivision();
	public Rdivision getRdivision(String division_id);
	public boolean deleteRdivision(String division_id);

}