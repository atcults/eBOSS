package org.sanelib.eboss.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnitOfWork {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession;
	private Transaction currentTransaction;

	public void begin() {
		this.currentSession = sessionFactory.openSession();
		this.currentTransaction = currentSession.beginTransaction();
	}

	public Session getCurrentSession() {
		return this.currentSession;
	}

	public void flush() {
		this.currentSession.flush();
	}

	public void clear() {
		this.currentSession.clear();
	}

	public void commit() {
		this.currentTransaction.commit();
		this.currentSession.close();
	}

	public void rollback() {
		if(this.currentTransaction == null){
			return;
		}

		this.currentTransaction.rollback();
	}
}
