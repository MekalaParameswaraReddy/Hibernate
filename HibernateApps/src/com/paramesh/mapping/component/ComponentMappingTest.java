package com.paramesh.mapping.component;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.paramesh.initialize.InitializeResource;

/**
 * Hibernate component represents as a group of values or properties, not entity
 * (table)
 */
public class ComponentMappingTest {
	Session session = null;
	InitializeResource initializeResource = null;

	/**
	 * Default Constructor
	 */
	public ComponentMappingTest() {
		initializeResource = new InitializeResource();
		session = initializeResource.getSession();
	}

	public void componentMappingSave() {
		System.out.println("component Mapping --- @start");
		Transaction tx = session.beginTransaction();
		tx.begin();
		Customer cust = new Customer();
		cust.setCustId(10);
		cust.setCustName("Bob");
		cust.setAge(36);
		Address address = new Address();
		address.setAddress1("USA");
		address.setAddress2("UK");
		address.setAddress3("Chaina");
		cust.setAddress(address);
		cust.setCreatedDate(new Date());
		cust.setCreatedBy("God");
		session.save(cust);
		tx.commit();
		System.out.println("component Mapping --- @end");
	}

	public static void main(String[] args) {
		ComponentMappingTest componentMappingTest = new ComponentMappingTest();
		componentMappingTest.componentMappingSave();
	}

}
