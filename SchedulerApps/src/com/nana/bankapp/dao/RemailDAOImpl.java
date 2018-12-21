package com.nana.bankapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nana.bankapp.entity.RemailEntity;
import com.nana.bankapp.model.Remail;

@Repository
public class RemailDAOImpl implements RemailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveRemail(Remail remail) {
		boolean saveFlag = true;
		RemailEntity remailEntity = new RemailEntity();
		remailEntity.setEmail_id(remail.getEmail_id());
		remailEntity.setSender(remail.getSender());
		remailEntity.setRecipients(remail.getRecipients());
		remailEntity.setSubject(remail.getSubject());
		remailEntity.setHeader(remail.getHeader());
		remailEntity.setFooter(remail.getFooter());
		remailEntity.setContent(remail.getContent());
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(remailEntity);
//			currentSession.save(accountEntity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			saveFlag = false;
		}
		return saveFlag;
	}

	@Override
	public List<Remail> getRemail() {
		List<Remail> list = new ArrayList<Remail>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<RemailEntity> query = session.createQuery("FROM RemailEntity", RemailEntity.class);
			List<RemailEntity> remails = query.getResultList();

			for (int i = 0; i < remails.size(); i++) {
				RemailEntity remailEntity = (RemailEntity) remails.get(i);
				Remail remail = new Remail();
				remail.setEmail_id(remailEntity.getEmail_id());
				remail.setSender(remailEntity.getSender());
				remail.setRecipients(remailEntity.getRecipients());
				remail.setSubject(remailEntity.getSubject());
				remail.setHeader(remailEntity.getHeader());
				remail.setFooter(remailEntity.getFooter());
				remail.setContent(remailEntity.getContent());
				list.add(remail);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Remail getRemail(String getEmail_id) {
		Remail remail = new Remail();

		try {
			Session session = sessionFactory.getCurrentSession();
			RemailEntity remailEntity = (RemailEntity) session.load(RemailEntity.class, getEmail_id);
			remail.setEmail_id(remailEntity.getEmail_id());
			remail.setSender(remailEntity.getSender());
			remail.setRecipients(remailEntity.getRecipients());
			remail.setSubject(remailEntity.getSubject());
			remail.setHeader(remailEntity.getHeader());
			remail.setFooter(remailEntity.getFooter());
			remail.setContent(remailEntity.getContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return remail;
	}

	@Override
	public boolean deleteRemail(String getEmail_id) {
		boolean deleteFlag = true;
		try {
			Session session = sessionFactory.getCurrentSession();
			RemailEntity remailEntity = (RemailEntity) session.load(RemailEntity.class, getEmail_id);
			session.delete(remailEntity);
		} catch (Exception e) {
			e.printStackTrace();
			deleteFlag = false;
		}
		return deleteFlag;
	}

}
