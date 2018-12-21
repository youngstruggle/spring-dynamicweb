package com.nana.bankapp.dao;

import java.util.List;

import com.nana.bankapp.model.Rdivision;

public interface RdivisionDAO {

	public boolean saveRdivision(Rdivision rdivision);
	public List<Rdivision> getRdivision();
	public Rdivision getRdivision(String division_id);
	public boolean deleteRdivision(String division_id);

}