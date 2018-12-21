package com.nana.bankapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nana.bankapp.entity.RcustomerEntity;
import com.nana.bankapp.model.Rcustomer;

@Repository
public class RcustomerDAOImpl implements RcustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveRcustomer(Rcustomer rcustomer) {
		// TODO Auto-generated method stub
		boolean saveFlag = true;
		RcustomerEntity rcustomerEntity = new RcustomerEntity();
		rcustomerEntity.setCustomer_id(rcustomer.getCustomer_id());
		rcustomerEntity.setCustomer_name(rcustomer.getCustomer_name());
		rcustomerEntity.setEmail_address(rcustomer.getEmail_address());

		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(rcustomerEntity);
//		    currentSession.save(accountEntity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			saveFlag = false;
		}
		return saveFlag;
	}

	@Override
	public List<Rcustomer> getRcustomers() {
		List<Rcustomer> list = new ArrayList<Rcustomer>();

		try {
			Session session = sessionFactory.getCurrentSession();
			Query<RcustomerEntity> query = session.createQuery("FROM RcustomerEntity", RcustomerEntity.class);
			List<RcustomerEntity> rcustomers = query.getResultList();

			for (int i = 0; i < rcustomers.size(); i++) {
				RcustomerEntity rcustomerEntity = (RcustomerEntity) rcustomers.get(i);
				Rcustomer rcustomer = new Rcustomer();
				rcustomer.setCustomer_id(rcustomerEntity.getCustomer_id());
				rcustomer.setCustomer_name(rcustomerEntity.getCustomer_name());
				rcustomer.setEmail_address(rcustomerEntity.getEmail_address());
				list.add(rcustomer);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Rcustomer getRcustomer(String customer_id) {
		Rcustomer rcustomer = new Rcustomer();
		try {
			Session session = sessionFactory.getCurrentSession();
			RcustomerEntity rcustomerEntity = (RcustomerEntity) session.load(RcustomerEntity.class, customer_id);
			rcustomer.setCustomer_id(rcustomerEntity.getCustomer_id());
			rcustomer.setCustomer_name(rcustomerEntity.getCustomer_name());
			rcustomer.setEmail_address(rcustomerEntity.getEmail_address());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rcustomer;
	}
	
	@Override
	public boolean deleteRcustomer(String customer_id) {
		boolean deleteFlag = true;
		try {
			Session session = sessionFactory.getCurrentSession();
			RcustomerEntity rcustomerEntity = (RcustomerEntity) session.load(RcustomerEntity.class, customer_id);
			session.delete(rcustomerEntity);
		} catch (Exception e) {
			e.printStackTrace();
			deleteFlag = false;
		}
		return deleteFlag;
	}

}
