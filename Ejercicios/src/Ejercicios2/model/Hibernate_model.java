package Ejercicios2.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hibernate_model {

	Session session;
	Transaction transaction;	
	SessionFactory factoria;

	public Hibernate_model() {

		this.factoria = new Configuration().configure().buildSessionFactory();
		this.session = factoria.openSession();
		this.transaction = session.beginTransaction();

	}

}
