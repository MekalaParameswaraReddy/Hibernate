package com.paramesh.mapping.inheritance;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.paramesh.initialize.InitializeResource;

/**
 * Hibernate component represents as a group of values or properties, not entity
 * (table)
 */
public class InheritanceMappingTest {
	Session session = null;
	InitializeResource initializeResource = null;

	/**
	 * Param Constructor :  passing the cfg file externally.
	 */
	public InheritanceMappingTest(String configFile) {
		initializeResource = new InitializeResource();
		session = initializeResource.getSession(configFile);
	}
	
	public InheritanceMappingTest() {
		initializeResource = new InitializeResource();
		session = initializeResource.getSession();
	}

	/**
	 * By this inheritance strategy, we can map the whole hierarchy by single
	 * table only. Here, an extra column (also known as discriminator column) is
	 * created in the table to identify the class.
	 */
	public void tablePerClasses() {
		System.out.println("Inheritance Mapping: Table per class --- @start");
		Transaction tx = session.beginTransaction();

		Payments payments = new Payments();
		payments.setPaymentId(101);
		payments.setCustomerName("Paramesh");
		payments.setPaymentAmount(10000);

		CashPayment cashPayment = new CashPayment();
		cashPayment.setCashPaymentId("A1A2234");
		cashPayment.setPersonName("Paramesh-Friend");

		ChequePayment chequePayment = new ChequePayment();
		chequePayment.setChequePaymentId("A1A2A3");
		chequePayment.setChequeHolderName("Paramesh");
		chequePayment.setChequeType("closed");

		/*
		 * session.persist(payments); session.persist(chequePayment);
		 * session.persist(cashPayment);
		 */

		session.save(payments);
		session.save(chequePayment);
		session.save(cashPayment);

		tx.commit();
		session.close();
		System.out.println("Inheritance Mapping: Table per class --- @end");
	}
	
	/**
	 * In case of Table Per Concrete class, there will be three tables in the database having no relations to each other. 
	 * 
	 * In between tables no relations.
	 */
	public void tablePerConcreteClass() {
		System.out.println("Inheritance Mapping: Table per Concrete class --- @start");
		Transaction tx = session.beginTransaction();

		Payments payments = new Payments();
		payments.setPaymentId(105);
		payments.setCustomerName("Paramesh");
		payments.setPaymentAmount(10000);

		CashPayment cashPayment = new CashPayment();
		cashPayment.setPaymentId(106);
		cashPayment.setCustomerName("Paramesh");
		cashPayment.setPaymentAmount(10000);
		cashPayment.setCashPaymentId("A1A2234");
		cashPayment.setPersonName("Paramesh-Friend");

		ChequePayment chequePayment = new ChequePayment();
		chequePayment.setPaymentId(107);
		chequePayment.setCustomerName("Paramesh");
		chequePayment.setPaymentAmount(10000);
		chequePayment.setChequePaymentId("A1A2A3");
		chequePayment.setChequeHolderName("Paramesh");
		chequePayment.setChequeType("closed");

		/*
		 * session.persist(payments); session.persist(chequePayment);
		 * session.persist(cashPayment);
		 */

		session.save(payments);
		session.save(chequePayment);
		session.save(cashPayment);

		tx.commit();
		session.close();
		System.out.println("Inheritance Mapping: Table per Concrete class --- @end");
	}
	
	/**
	 * In case of Table Per Subclass, subclass mapped tables are related to
	 * parent class mapped table by primary key and foreign key relationship.
	 * 
	 * The <joined-subclass> element of class is used to map the child class
	 * with parent using the primary key and foreign key relation
	 */
	public void tablePerSubClass() {
		System.out.println("Inheritance Mapping: Table per Sub class --- @start");
		Transaction tx = session.beginTransaction();

		Payments payments = new Payments(); 
		payments.setPaymentId(101);
		payments.setCustomerName("Paramesh_1");
		payments.setPaymentAmount(10000);
		

		CashPayment cashPayment = new CashPayment();
		cashPayment.setPaymentId(101);
		cashPayment.setCustomerName("Paramesh_1");
		cashPayment.setPaymentAmount(30000);
		cashPayment.setCashPaymentId("XYZ-A1A2234");
		cashPayment.setPersonName("Paramesh-Friend1");

		ChequePayment chequePayment = new ChequePayment();
		chequePayment.setPaymentId(102);
		chequePayment.setCustomerName("Paramesh_2");
		chequePayment.setPaymentAmount(40400);
		chequePayment.setChequePaymentId("ABC-wA1A2A3");
		chequePayment.setChequeHolderName("Paramesh-X-Friend2");
		chequePayment.setChequeType("closed");

		/*
		 * session.persist(payments); session.persist(chequePayment);
		 * session.persist(cashPayment);
		 */
		// We can save [payments] obj or not i.e up to us.
		session.save(payments);
		session.save(chequePayment);
		session.save(cashPayment);

		tx.commit();
		session.close();
		System.out.println("Inheritance Mapping: Table per Sub class --- @end");
	}
	
	public static void main(String[] args) {
		/*InheritanceMappingTest test = new InheritanceMappingTest();
		test.tablePerClasses();*/
		
		InheritanceMappingTest inheritanceMappingTest = new InheritanceMappingTest("Payments_InhertanceMapping.cfg.xml");
		//inheritanceMappingTest.tablePerClasses();
		//inheritanceMappingTest.tablePerConcreteClass();
		inheritanceMappingTest.tablePerSubClass();		
	}
}
