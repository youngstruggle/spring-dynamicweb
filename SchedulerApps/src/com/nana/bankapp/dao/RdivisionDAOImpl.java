package com.nana.bankapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nana.bankapp.entity.RdivisionEntity;
import com.nana.bankapp.model.Rdivision;

@Repository
public class RdivisionDAOImpl implements RdivisionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveRdivision(Rdivision rdivision) {
		boolean saveFlag = true;
		RdivisionEntity rdivisionEntity = new RdivisionEntity();
		rdivisionEntity.setDivision_id(rdivision.getDivision_id());
		rdivisionEntity.setDivision_name(rdivision.getDivision_name());
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(rdivisionEntity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			saveFlag = false;
		}
		return saveFlag;
	}

	@Override
	public List<Rdivision> getRdivision() {
		List<Rdivision> list = new ArrayList<Rdivision>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query <RdivisionEntity> query = session.createQuery("FROM RdivisionEntity", RdivisionEntity.class);
			List<RdivisionEntity> rdivision = query.getResultList();
			
			for (int i = 0; i < rdivision.size(); i++) {
				RdivisionEntity rdivisionEntity = (RdivisionEntity) rdivision.get(i);
				Rdivision rdivison = new Rdivision();
				rdivison.setDivision_id(rdivisionEntity.getDivision_id());
				rdivison.setDivision_name(rdivisionEntity.getDivision_name());
				list.add(rdivison);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Rdivision getRdivision(String division_id) {
		Rdivision rdivision = new Rdivision();
		try {
			Session session = sessionFactory.getCurrentSession();
			RdivisionEntity rdivisionEntity = (RdivisionEntity) session.load(RdivisionEntity.class, division_id);
			rdivision.setDivision_id(rdivisionEntity.getDivision_id());
			rdivision.setDivision_name(rdivisionEntity.getDivision_name());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rdivision;
	}

	@Override
	public boolean deleteRdivision(String division_id) {
		// TODO Auto-generated method stub
		boolean deleteFlag = true;
		try {
			Session session = sessionFactory.getCurrentSession();
			RdivisionEntity rdivisionEntity = (RdivisionEntity) session.load(RdivisionEntity.class, division_id);
			session.delete(rdivisionEntity);
		} catch (Exception e) {
			e.printStackTrace();
			deleteFlag = false;
		}
		return deleteFlag;
	}

}
