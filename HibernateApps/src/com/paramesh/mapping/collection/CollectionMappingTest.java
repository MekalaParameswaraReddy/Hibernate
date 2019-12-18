package com.paramesh.mapping.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.paramesh.initialize.InitializeResource;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class CollectionMappingTest {
	
	Session session = null;
	InitializeResource initializeResource = null;

	/**
	 * Default Constructor
	 */
	CollectionMappingTest(){
		initializeResource = new InitializeResource();
		session = initializeResource.getSession();
	}
	
	public void mappingList_Insert() {
		System.out.println("Collection Mapping: List --- @Start");
		Transaction tx = session.beginTransaction();
		List<String> list = new ArrayList<String>();
		list.add("Benifit plan -A");
		list.add("Benifit plan -B");
		list.add("Benifit plan -C");
		list.add("Benifit plan -D");
		list.add("Benifit plan -D");
		list.add("Benifit plan -D");
		Member member = new Member();
		member.setMemberId(101);
		member.setName("Paramesh");
		member.setBenifitPlan(list);
		session.save(member);
		tx.commit();
		System.out.println("Collection Mapping: List --- @Start");
	}
	public void mappingBag_Insert() {
		System.out.println("Collection Mapping: Bag --- @Start");
		Transaction tx = session.beginTransaction();
		List<String> list = new ArrayList<String>();
		list.add("Benifit plan -A");
		list.add("Benifit plan -B");
		list.add("Benifit plan -C");
		list.add("Benifit plan -D");
		list.add("Benifit plan -D");
		list.add("Benifit plan -D");
		Member member = new Member();
		member.setMemberId(101);
		member.setName("Paramesh3");
		member.setBenifitPlan(list);
		session.save(member);
		tx.commit();
		System.out.println("Collection Mapping: Bag --- @Start");
	}
	
	public void mappingSet_Insert() {
		System.out.println("Collection Mapping: Set --- @Start");
		Transaction tx = session.beginTransaction();
		//Set<String> set = new HashSet<String>();
		Set<String> set = new TreeSet<String>();
		set.add("Benifit plan -A");
		set.add("Benifit plan -B");
		set.add("Benifit plan -C");
		set.add("Benifit plan -D");
		set.add("Benifit plan -D");
		set.add("Benifit plan -D");
		Member member = new Member();
		member.setMemberId(101);
		member.setName("Paramesh4");
		member.setUniqueBenifitPlan(set);
		session.save(member);
		tx.commit();
		System.out.println("Collection Mapping: Set --- @Start");
	}
	
	public void mappingMap_Insert() {
		System.out.println("Collection Mapping: Map --- @Start");
		Transaction tx = session.beginTransaction();		
		Map<String,String> map = new HashMap<String, String>();
		map.put("CHIP", "Children's Health Insurance Program ");
		map.put("AHP","Association Health Plan");
		map.put("BCBSA","Blue Cross Blue Shield Association");
		map.put("HMO","health maintenance organization");
		map.put("MCO","managed care organization");
		map.put("GDHP","High-deductible health plan");
		map.put("MCO","managed care organization_2");
		map.put("GDHP","High-deductible health plan_2");
		Member member = new Member();
		member.setMemberId(101);
		member.setName("Parames17");
		member.setPlanNameAndExplanation(map);
		session.save(member);
		tx.commit();
		System.out.println("Collection Mapping: Map --- @Start");
	}
	public static void main(String[] args) {		
		CollectionMappingTest test = new CollectionMappingTest();
		//test.mappingList_Insert();
		//test.mappingBag_Insert();
		//test.mappingSet_Insert();
		test.mappingMap_Insert();
	}

}
