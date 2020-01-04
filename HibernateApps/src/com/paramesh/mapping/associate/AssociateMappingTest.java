package com.paramesh.mapping.associate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.paramesh.initialize.InitializeResource;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class AssociateMappingTest {
	
	Session session = null;
	InitializeResource initializeResource = null;

	AssociateMappingTest(String configFile) {
		initializeResource = new InitializeResource();
		session = initializeResource.getSession(configFile);
	}
	/**
	 * If the persistent class has list object that contains the entity reference, we need to use one-to-many association to map the list element.
	 */
	public void oneToMany_Insert(){
		System.out.println(" Associate Mapping : one to many :Insert --- @ Start...");
		Transaction tx = session.beginTransaction();
		
		List<StockDetails> list1 = new ArrayList<StockDetails>();
		StockDetails stockDetails1 = new StockDetails();
		stockDetails1.setStockDetailsId(7);
		stockDetails1.setOpenPrice(111);
		stockDetails1.setClosePrice(105);
		stockDetails1.setValuems(120000);
		stockDetails1.setMonth("Jan");
		
		//List<StockDetails> list2 = new ArrayList<StockDetails>();
		StockDetails stockDetails2 = new StockDetails();
		stockDetails2.setStockDetailsId(8);
		stockDetails2.setOpenPrice(111);
		stockDetails2.setClosePrice(110);
		stockDetails2.setValuems(130000);
		stockDetails2.setMonth("Feb");
		
		list1.add(stockDetails1);
		list1.add(stockDetails2);
		//list2.add(stockDetails2);
		
		Stock stock1 = new Stock();
		stock1.setStockId(13);;
		stock1.setStockName("vedanta13");
		stock1.setStockDetails(list1);
		
		/*Stock stock2 = new Stock();
		stock2.setStockId(12);
		stock2.setStockName("vedanta");
		stock2.setStockDetails(list2);*/
		
		session.save(stock1);
		//session.save(stock2);
		tx.commit();
		session.close();
		System.out.println(" Associate Mapping : one to many :Insert: --- @ End...");
	}
	
	public void oneToMany_Fetch(){
		System.out.println(" Associate Mapping : one to many : Featch: --- @ Start...");
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Stock");
		List<Stock> list = query.list();
		for(Stock stock : list){
			int id = stock.getStockId();
			String name = stock.getStockName();
			System.out.print(id + " "+ name + " ");
			List<StockDetails> stockDetailsList = stock.getStockDetails();
			
			for(StockDetails StockDetails : stockDetailsList){
				System.out.println(
						StockDetails.getStockDetailsId() + " " +
						StockDetails.getOpenPrice() + " " + 
						StockDetails.getClosePrice() + " " + 
						StockDetails.getValuems() + " " + 
						StockDetails.getMonth());		
			}
			System.out.println("*************************************");
		}
		
		tx.commit();
		session.close();
		System.out.println(" Associate Mapping : one to many :Fetch: --- @ End...");
	}
	/**
	 * Many-to-many relationships occur when each record in an entity may have many linked records in another entity and vice-versa.
	 */
	public void manyToMany_Insert(){
		System.out.println(" Associate Mapping : many to many :Insert --- @ Start...");
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setId(100);
		user.setName("Paramesh");
		
		Role role1 = new Role();
		role1.setId(1000);
		role1.setDescription("developer");
		
		Role role2 = new Role();
		role2.setId(1001);
		role2.setDescription("Testing");
		
		Set<Role> set = new HashSet<Role>();
		set.add(role1);
		set.add(role2);
		
		user.setRoles(set);
		
		session.save(user);
		
		tx.commit();
		session.close();
		System.out.println(" Associate Mapping : many to many :Insert: --- @ End...");
	}
	
	public void oneToOne_Insert(){
		System.out.println(" Associate Mapping : one to one :Insert --- @ Start...");
		Transaction tx = session.beginTransaction();
		
		Student student = new Student();
		student.setId(102);
		student.setName("Pranav");
		
		ContactInformation contactInformation = new ContactInformation();
		contactInformation.setHomeNumber(12345);
		contactInformation.setPersonlaNumber(97910293);
			
		student.setContactInformation(contactInformation);
		contactInformation.setStudent(student);
		
		session.save(student);		
		tx.commit();
		session.close();
		System.out.println(" Associate Mapping : one to one :Insert: --- @ End...");
	}
	
	public static void main(String[] args) {
		AssociateMappingTest test = new AssociateMappingTest("AssociateMapping.cfg.xml");
		//test.oneToMany_Insert();
		//test.oneToMany_Fetch();
		test.manyToMany_Insert();
		//test.oneToOne_Insert();
	}
}
