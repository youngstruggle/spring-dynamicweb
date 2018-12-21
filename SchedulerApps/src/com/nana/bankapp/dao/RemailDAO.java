package com.nana.bankapp.dao;

import java.util.List;

import com.nana.bankapp.model.Remail;

public interface RemailDAO {

	public boolean saveRemail(Remail remail);
	public List<Remail> getRemail();
	public Remail getRemail(String getEmail_id);
	public boolean deleteRemail(String getEmail_id);

}