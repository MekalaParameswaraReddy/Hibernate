package com.paramesh.initialize;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class InitializeResource {

	Configuration configuration = null;
	SessionFactory factroy = null;
	Session session = null;

	/**
	 * creating the session and return to the caller.
	 */
	public Session getSession() {
		configuration = new Configuration();
		configuration = configuration.configure();
		factroy = configuration.buildSessionFactory();
		session = factroy.openSession();
		return session;
	}

	/**
	 * creating the session with given cfg file.
	 * 
	 */
	public Session getSession(String configFile) {
		configuration = new Configuration();
		configuration = configuration.configure(configFile);
		factroy = configuration.buildSessionFactory();
		session = factroy.openSession();
		return session;
	}
	
	/**
	 * closing the session based on need.
	 */
	public void destroySession(Session session) {
		if (session != null) {
			session.close();
			System.out.println("Seesion is closed...");
		} else {
			System.out.println("There is no existing session to close!");
		}
	}
}
