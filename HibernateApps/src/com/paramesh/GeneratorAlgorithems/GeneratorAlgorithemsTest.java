package com.paramesh.GeneratorAlgorithems;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.paramesh.initialize.InitializeResource;
import com.paramesh.pojo.Employee;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class GeneratorAlgorithemsTest {

	Session session = null;
	InitializeResource initializeResource = null;

	/**
	 * Default Constructor
	 */
	public GeneratorAlgorithemsTest() {
		initializeResource = new InitializeResource();
		session = initializeResource.getSession();
	}
	/**
	 * It is the default one if there is no <generator> element, hibernate automaticall assigns it.
	 * 	
	 */
	public void assignedGenerator(int id, String fname, String lname, String gender) {
		System.out.println("--- control is in assignedGenerator Method() --");
		Transaction tx = session.beginTransaction();
		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstname(fname);
		employee.setLastName(lname);
		employee.setGender(gender);
		Serializable pk = session.save(employee);
		System.out.println("Pk == " + pk);
		tx.commit();
		System.out.println(pk + "th rocord is inserted successfully");
		initializeResource.destroySession(session);
	}
	/**
	 * It generates short, int or long type identifier.
	 * 
	 * hibernate increment the identifier by 1 (Max +1).
	 */
	public void incrementGenerator(int id, String fname, String lname, String gender) {
		System.out.println("--- control is in incrementGenerator Method() --");
		Transaction tx = session.beginTransaction();
		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstname(fname);
		employee.setLastName(lname);
		employee.setGender(gender);
		Serializable pk = session.save(employee);
		System.out.println("Pk == " + pk);
		tx.commit();
		System.out.println(pk + "th rocord is inserted successfully");
		initializeResource.destroySession(session);
	}
	/**
	 * MySQL does not support sequences
	 * 
	 */
	public void sequencesGenerator(int id, String fname, String lname, String gender) {
		System.out.println("--- control is in incrementGenerator Method() --");
		Transaction tx = session.beginTransaction();
		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstname(fname);
		employee.setLastName(lname);
		employee.setGender(gender);
		Serializable pk = session.save(employee);
		System.out.println("Pk == " + pk);
		tx.commit();
		System.out.println(pk + "th rocord is inserted successfully");
		initializeResource.destroySession(session);
	}

	public static void main(String[] args) {
		GeneratorAlgorithemsTest generators = new GeneratorAlgorithemsTest();
		int id = 108;
		String fname = "Madhavi1";
		String lname = "lalitha";
		String gender = "F";
		char ch = 'c';
		float f = 12.3f;
		double d = 123.34;
		long l = 1234;
		//generators.assignedGenerator(id, fname, lname, gender);
		generators.incrementGenerator(id, fname, lname, gender);
	}
}
