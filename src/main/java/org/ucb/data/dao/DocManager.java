package org.ucb.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.ucb.data.domain.Docs;

public class DocManager implements IDocManager{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Docs getDocById(int docId) {
		
		return (Docs) getSessionFactory().getCurrentSession().get(Docs.class, docId);
	}

	@Override
	public Docs getDocByName(String docName) {
		List<Docs> docList = getSessionFactory().getCurrentSession().createQuery("SELECT u FROM Docs "
				+ " u WHERE u.docName = :docName").setParameter("docName", docName).list();
		if(!docList.isEmpty())
			return docList.get(0);
		return null;
	}

	@Override
	public void storeDoc(Docs doc) {
		
		getSessionFactory().getCurrentSession().persist(doc);
	}

	@Override
	public void updateDoc(Docs doc) {
		
		getSessionFactory().getCurrentSession().update(doc);
	}

	@Override
	public void deleteDoc(Docs doc) {
		
		getSessionFactory().getCurrentSession().delete(doc);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
