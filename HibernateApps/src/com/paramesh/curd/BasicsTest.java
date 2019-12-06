package com.paramesh.curd;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.paramesh.initialize.InitializeResource;
import com.paramesh.pojo.Employee;
import com.paramesh.pojo.Person;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
public class BasicsTest {

	Session session = null;
	InitializeResource initializeResource = null;

	/**
	 * Default Constructor
	 */
	public BasicsTest() {
		initializeResource = new InitializeResource();
		session = initializeResource.getSession();
	}

	/**
	 * 
	 * Save() method will return Serializable object, it will return the
	 * generated identifier
	 */
	public void saveMethod(int id, String fname, String lname, String gender) {
		System.out.println(" ---- control is in saveMethod() -----");
		Transaction tx = session.beginTransaction();
		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstname(fname);
		employee.setLastName(lname);
		employee.setGender(gender);
		Serializable pk = session.save(employee);
		int empid = (int)pk;
		System.out.println("Pk == " + empid);
		tx.commit();
		System.out.println(empid + " th rocord is inserted successfully");
		//session.flush();
		initializeResource.destroySession(session);
	}	

	/**
	 * 
	 * persist() method will persist the given instance, and nothing will return
	 * (void)
	 * 
	 * we will get org.hibernate.PersistentObjectException: detached entity passed to persist: com.paramesh.pojo.Employee
	 * 
	 * when we enable <generator class="increment"></generator> in mapping file.
	 *
	 */
	public void persistMethod(int id, String fname, String lname, String gender) {
		System.out.println(" ---- control is in persistMethod() -----");
		Transaction tx = session.beginTransaction();
		session.beginTransaction();
		Employee emp = new Employee();
		emp.setId(id);
		emp.setFirstname(fname);
		emp.setLastName(lname);
		emp.setGender(gender);
		session.persist(emp);		
		tx.commit();
		System.out.println(id + "th rocord is inserted successfully");
		initializeResource.destroySession(session);
	}

	/**
	 * 
	 * saveOrUpdate() method : Either save (if the same record was not present)
	 * or update (if the same record was already present)
	 * 
	 * if we don't have <generator class="increment"></generator>
	 * 
	 * First hibernate will execute the select query, after that update query:
	 * if record is present
	 * 
	 * First hibernate will execute the select query, after that insert query:
	 * if record is not present
	 * 
	 * following 2 lines are applicable: if we  have <generator class="increment"></generator>
	 * 
	 * hibernate will execute update query: if record is present
	 *  
	 * hibernate will throw exception, insted of create [(org.hibernate.StaleStateException: Batch update returned unexpected row count from update [0]; actual row count: 0; expected: 1)]  : if record not present
	 */
	public void saveORUpdateMethod(int id, String fname, String lname, String gender) {
		System.out.println(" ---- control is in saveORUpdateMethod() -----");
		Transaction tx = session.beginTransaction();
		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstname(fname);
		employee.setLastName(lname);
		employee.setGender(gender);
		session.saveOrUpdate(employee);
		tx.commit();
		System.out.println(id + "th rocord is save/Updated successfully");
		initializeResource.destroySession(session);

	}

	/**
	 * When you call session.load() method, it will always return a “proxy”
	 * object. Proxy means, hibernate will prepare some fake object with given
	 * identifier value in the memory.
	 * 
	 * It will hit the database only when we try to retrieve the other
	 * properties : Ex employee.firstName(); [query will be framed]
	 * 
	 * input id is same for multipule calls, query will be executed only once,
	 * but values are displayed multiple times.
	 * 
	 * inpuy if id different for mulitipule calls, query will be executed multiple times.
	 * 
	 * if object [row] not found in the database it will throws
	 * ObjectNotFoundException.
	 * 
	 */
	public void loadMethod(int id) {
		System.out.println(" ---- control is in loadMethod() -----");
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee)session.load(Employee.class, new Integer(id));
		System.out.println("id == " + employee.getId());		
		System.out.println("employee details == " + employee.getFirstname());
		tx.commit();
		//initializeResource.destroySession(session);

	}

	/**
	 * When you call session.get() method, it will hit the database immediately
	 * and returns the original object.
	 * 
	 * If the row is not available in the database, it returns null, so we will get NullPointerException
	 * 
	 * To avoid NullPointerException we have to write null check condition.
	 * 
	 * if we have null check and record is not present in DB, query will be framed, if the query framed then only we come to know.
	 * 
	 * two time query will fram, because following method we are calling two times through getMethodTest(-) [Means no proxy object]
	 * 
	 */
	public void getMethod(int id) {
		String s = "s";
		System.out.println(" ---- control is in getMethod() -----");
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, new Integer(id));
		if(employee != null){
			System.out.println("id == " + employee.getId());
			System.out.println("employee details == " + employee.getFirstname());
		} else {
			System.out.println("supplied " + id + " is not present in database table.");
		}
		
		tx.commit();
		// initializeResource.destroySession(session);
	}

	/**
	 * 
	 * delete() method
	 */
	public void deletMethod(int id, String fname, String lname, String gender) {
		Transaction tx = session.beginTransaction();
		Employee employee = new Employee();
		employee.setId(id);
		//employee.setFirstname(fname);
		//employee.setLastName(lname);
		//employee.setGender(gender);		 
		session.delete(employee);
		tx.commit();
		System.out.println(id + "th rocord is deleted successfully");
		initializeResource.destroySession(session);
	}

	/**
	 * laod() method test
	 */
	public void loadMethodTest(int id) {
		try {
			loadMethod(id);
			Thread.sleep(1000);
			loadMethod(30);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * get() method test
	 */
	public void getMethodTest(int id) {
		try {
			getMethod(id);
			Thread.sleep(1000);
			getMethod(id);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	/**
	 * To test composite-id table must have more than one primary keys.
	 * 
	 * For composit key pojo class should be implement Serializable.
	 * 
	 * in case of primary key, it must be unique. but in case of composit key at least one column must be unique.
	 * following example id, aadhaar, ssn are primary keys, one values must be unique when saving the reocord.
	 */
	public void compositKeyTest() {
		System.out.println(" ---- control is in compositKeyTest() method -----");
		Transaction tx = session.beginTransaction();
		Person person = new Person();
		person.setId(1);
		person.setAadhaar(12342);
		person.setSocialSecurityNumber(12343);
		person.setFirstName("Paramesh");
		person.setLastName("Reddy");
		person.setGender("M");
		session.save(person);
		tx.commit();
	}
	/**
	 * Query will frame only participated columns/properties.
	 * 
	 * Hibernate: insert into person (id, aadhaar, social_security_number) values (?, ?, ?)
	 * 
	 * if no:: dynamic-insert="true" -->
	 * 
	 * Hibernate: insert into person (firstname, lastname, gender, id, aadhaar, social_security_number) values (?, ?, ?, ?, ?, ?)
	 *  
	 */
	public void dynamicInsertTrueTest() {
		System.out.println(" ---- control is in dynamicInsertTrueTest() method -----");
		Transaction tx = session.beginTransaction();
		Person person = new Person();
		person.setId(2);
		person.setAadhaar(12344);
		person.setSocialSecurityNumber(12344);
		//person.setFirstName("Paramesh");
		//person.setLastName("Reddy");
		//person.setGender("M");
		session.save(person);
		tx.commit();
	}
	
	/**
	 * Query will frame only participated columns/properties.
	 * if Present:: dynamic-update="true" -->
	 * 
	 * Hibernate: update Employee set gender=? where id=?
	 * 
	 * Condition is we should not create employee object, it should return from query object.
	 *  
	 */
	public void dynamicUpdateTrueTest() {
		System.out.println(" ---- control is in dynamicUpdateTrueTest() method -----");		
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Employee where id = :id ");
		q.setParameter("id", 17);
		Employee employee = (Employee)q.list().get(0);		
		employee.setId(17);
		//employee.setFirstname("Alexi");
		//employee.setLastName("lname");
		employee.setGender("M");		 
		session.update(employee);
		tx.commit();
		System.out.println("record is Updated successfully");
		initializeResource.destroySession(session);
	}
	
	/**
	 * The default value of dynamic-update is false, which means include unmodified properties in the Hibernate’s SQL update statement.
	 * 
	 * If set the dynamic-insert to true, which means exclude unmodified properties in the Hibernate’s SQL update statement.
	 * 
	 * Hibernate: update Employee set gender=? where id=?
	 * 
	 * Hibernate: update person set lastname=? where id=? and aadhaar=? and social_security_number=?
	 *  
	 * Composit key setter methods are not required, only other setter need to be place [which we need to update].
	 */
	public void dynamicUpdateTrueTest_Person() {		
		System.out.println(" ---- control is in dynamicUpdateTrueTest_Person -----");
		Transaction tx = session.beginTransaction();
		//Query q = session.createQuery("from Person where id = :id");
		//q.setParameter("id", 1);
		Query q = session.createQuery("from Person where id = :id and aadhaar =:aadhaar and socialSecurityNumber =:ssn");
		q.setParameter("id", 1);
		q.setParameter("aadhaar", 12342);
		q.setParameter("ssn", 12342);
		Person person = (Person)q.list().get(0);		
		//person.setId(1);
		//person.setAadhaar(12342);
		//person.setSocialSecurityNumber(12342);
		person.setLastName("Paramesh5");
		//person.setGender(gender);
		session.update(person);		
		tx.commit();
		System.out.println(" rocord is updated successfully");
		initializeResource.destroySession(session);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicsTest basicsTest = new BasicsTest();
		int id = 31;
		String Firstname = "C1";
		String LastName = "C2";
		String gender = "M";
		//basicsTest.saveMethod(id, Firstname, LastName, gender);
		//basicsTest.persistMethod(id, Firstname, LastName, gender);
		//basicsTest.saveORUpdateMethod(id, Firstname, LastName, gender);		
		//basicsTest.deletMethod(id, Firstname, LastName, gender);		
		//basicsTest.getMethodTest(id);
		//basicsTest.loadMethodTest(id);
		//basicsTest.compositKeyTest();
		//basicsTest.dynamicInsertTrueTest();
		//basicsTest.dynamicUpdateTrueTest();	
		basicsTest.dynamicUpdateTrueTest_Person();

	}
}
