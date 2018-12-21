package com.nana.bankapp.services;

import java.util.List;

import javax.transaction.Transactional;

import com.nana.bankapp.model.Remail;

public interface RemailService {

	boolean saveRemail(Remail remail);

	List<Remail> getRemail();

	Remail getRemail(String getEmail_id);

	boolean deleteRemail(String getEmail_id);

}