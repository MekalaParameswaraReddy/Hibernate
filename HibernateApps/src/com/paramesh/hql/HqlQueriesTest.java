package com.paramesh.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.paramesh.initialize.InitializeResource;
import com.paramesh.pojo.Employee;

/**
 * HQl Queries are database independent.
 */
public class HqlQueriesTest {

	Session session = null;
	InitializeResource initializeResource = null;

	/**
	 * Default Constructor
	 */
	public HqlQueriesTest() {
		initializeResource = new InitializeResource();
		session = initializeResource.getSession();
	}
	/**
	 * 
	 * 
	 * query.list() is use to retrive all the columns of the table.
	 */
	public void listTest() {
		// Query query = session.createQuery("from Employee");
		// Query query = session.createQuery("from Employee as emp");
	
		Query query = session.createQuery("select emp from Employee as emp");
		String[] arr = query.getReturnAliases();
		for(int i=0; i<arr.length ;++i) {
			System.out.println("Aliases  ==> " + arr[i]);
		}
		
		List<Employee> list = query.list();
		for (int i = 0; i < list.size(); ++i) {
			Employee employee = list.get(i);
			System.out.println(employee.getId() + " | " + employee.getFirstname()
							+ " | " + employee.getLastName() + " | "
							+ employee.getGender());
		}
	}
	/**
	 * query.iterate() is used to select some columns, not for all columns.
	 * 
	 *  if any null values in table, will cause to nullpointer exception.
	 * 
	 */
	public void iteratorTest() {
		Query query = session.createQuery("select emp.id, emp.Firstname, emp.LastName from Employee as emp");
		Iterator iterator = query.iterate();
		while(iterator.hasNext()){
			Object obj[] = (Object[])iterator.next();
			for(int i= 0;i<obj.length;++i){
				System.out.print(obj[i].toString()+ " ");
			}
			System.out.println();
		}
		/**
		 * Employee employee = list.get(i) : we can not cast, because we are having insufficient properties of emploee class.
		 */
		/*List<Employee> list = query.list();
		for (int i = 0; i < list.size(); ++i) {
			Employee employee = list.get(i);
			System.out.println(employee.getId() + " | " + employee.getFirstname()
							+ " | " + employee.getLastName() + " | "
							+ employee.getGender());
		}*/
	}

	public void maxIdTest() {
		Query query = session.createQuery("select max(id) from Employee as emp");
		List list = query.list();
		System.out.println(list.get(0) + "  :: Through List ");
		
		Iterator iterator = query.iterate();
		while(iterator.hasNext()){
			Object obj = iterator.next();			
			System.out.println(obj.toString() + " :: Through Iterator ");
		}
	}
	
	public void subQeriesTest() {
		System.out.println("--- Control is in subquery test method ----");
		Query query = session.createQuery("select emp from Employee as emp where emp.id >=(select max(id) from Employee as emp1)");
		List<Employee> list = query.list();
		for (int i = 0; i < list.size(); ++i) {
			Employee employee = list.get(i);
			System.out.println(employee.getId() + " | " + employee.getFirstname()
					+ " | " + employee.getLastName() + " | "
					+ employee.getGender());
		}
	}
	
	public void rangeControlTest() {
		System.out.println("--- Control is in Range control test method ----");
		Query query = session.createQuery("select emp from Employee as emp");
		query.setFirstResult(0);
		query.setMaxResults(4);
		List<Employee> list = query.list();
		for (int i = 0; i < list.size(); ++i) {
			Employee employee = list.get(i);
			System.out.println(employee.getId() + " " + employee.getFirstname() +" " +employee.getLastName()+ " " + employee.getGender());
		}
	}
	
	/**
	 * we get exception if we have more than one record: org.hibernate.NonUniqueResultException: query did not return a unique result: 4
	 */
	public void uniqueResultTest() {
		System.out.println("--- Control is in unique result test method ----");
		Query query = session.createQuery("select emp from Employee as emp where emp.id >=15");
		//Query query = session.createQuery("select emp from Employee as emp where emp.LastName ='kumar' ");
		Employee employee= (Employee)query.uniqueResult();
		System.out.println(employee.getId() + " " + employee.getFirstname() +" " +employee.getLastName()+ " " + employee.getGender());
		/*List<Employee> list = query.list();
		for (int i = 0; i < list.size(); ++i) {
			Employee employee = list.get(i);
			System.out.println(employee.getId() + " " + employee.getFirstname() +" " +employee.getLastName()+ " " + employee.getGender());
		}*/
	}
	/**
	 * no nullpointer exception, even table have null values
	 */
	public void namedParametersTest() {
		System.out.println("--- Control is in named Parameters Test method ----");
		/*Query query = session.createQuery("select emp from Employee as emp where emp.id >=:p1 ");
		query.setInteger("p1", 11 );*/		
		Query query = session.createQuery("select emp from Employee as emp where emp.id >=:p1 and firstName like :p2");
		query.setInteger("p1", 11 );
		query.setString("p2", "m%");		
		List<Employee> list = query.list();
		for (int i = 0; i < list.size(); ++i) {
			Employee employee = list.get(i);
			System.out.println(employee.getId() + " " + employee.getFirstname() +" " +employee.getLastName()+ " " + employee.getGender());
		}
	}
	/**
	 * if any null values in table, will cause to nullpointer exception.
	 */
	public void namedParameters_iterator_Test() {
		System.out.println("--- Control is in named Parameters _ iterator Test method ----");
		Query query = session.createQuery("select emp.id, emp.Firstname, emp.LastName from Employee as emp where emp.id >=:p1 and firstName like :p2");
		query.setInteger("p1", 11 );
		query.setString("p2", "m%");		
		Iterator iterator = query.iterate();
		while(iterator.hasNext()){
			Object obj[] = (Object[])iterator.next();
			for(int i= 0;i<obj.length;++i){
				System.out.print(obj[i].toString()+ " ");
			}
			System.out.println();
		}
	}
	/**
	 * positional parameters index start with index zero.
	 */
	public void positionalParamestersTest() {
		System.out.println("--- Control is in named Parameters Test method ----");
		Query query = session.createQuery("select emp from Employee as emp where emp.id >=? and firstName like ?");
		query.setInteger(0, 11 );
		query.setString(1, "m%");		
		List<Employee> list = query.list();
		for (int i = 0; i < list.size(); ++i) {
			Employee employee = list.get(i);
			System.out.println(employee.getId() + " " + employee.getFirstname() +" " +employee.getLastName()+ " " + employee.getGender());
		}
	}
	
	/**
	 * named parameters must be placed after positional parameters. because positional parameters are using index.
	 */
	public void combinationOfPosition_NamedParameters() {
		System.out.println("--- Control is in named Parameters Test method ----");
		Query query = session.createQuery("select emp from Employee as emp where emp.id >=? and firstName like :p1");
		query.setInteger(0, 11 );
		query.setString("p1", "m%");		
		List<Employee> list = query.list();
		for (int i = 0; i < list.size(); ++i) {
			Employee employee = list.get(i);
			System.out.println(employee.getId() + " " + employee.getFirstname() +" " +employee.getLastName()+ " " + employee.getGender());
		}
	}
	
	/**
	 * All HQL non select quires must be executed under Transactional statement.
	 */
	public void HqlUpdate() {
		
		System.out.println("--- Control is in Hql Updatemethod ----");
		Query query = session.createQuery("update Employee as emp set emp.Firstname =:val1, emp.LastName =:val2 where emp.id=:val3");
		query.setString("val1", "Manu12" );
		query.setString("val2", "Reddy12");
		query.setInteger("val3", 15);
		System.out.println("query  ==> " + query.getQueryString());		
		Transaction Tx = session.beginTransaction();
		int result = query.executeUpdate();
		Tx.commit();
		System.out.println(result+ "record is updated");
		
	}
	/**
	 * All HQL non select quires must be executed under Transactional statement.
	 */
	public void Hqldelete() {		
		System.out.println("--- Control is in Hql delete method ----");
		Query query = session.createQuery("delete Employee as emp where emp.id=? and emp.Firstname like ?");
		query.setInteger(0, 29);
		query.setString(1, "a%");
		Transaction Tx = session.beginTransaction();
		int result = query.executeUpdate();
		Tx.commit();
		System.out.println(result+ "record is deleted");
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HqlQueriesTest hqlQueriesTest = new HqlQueriesTest();
		//hqlQueriesTest.listTest();
		//hqlQueriesTest.iteratorTest();
		//hqlQueriesTest.maxIdTest();
		//hqlQueriesTest.subQeriesTest();
		//hqlQueriesTest.rangeControlTest();
		//hqlQueriesTest.uniqueResultTest();
		//hqlQueriesTest.namedParametersTest();
		//hqlQueriesTest.namedParameters_iterator_Test();
		//hqlQueriesTest.positionalParamestersTest();
		//hqlQueriesTest.combinationOfPosition_NamedParameters();
		//hqlQueriesTest.HqlUpdate();
		hqlQueriesTest.Hqldelete();
	}
}
