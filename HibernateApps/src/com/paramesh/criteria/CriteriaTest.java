package com.paramesh.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.paramesh.initialize.InitializeResource;
import com.paramesh.pojo.Employee;

/**
 * The Hibernate Session interface provides createCriteria() method, which can
 * be used to create a Criteria object that returns instances of the persistence
 * object's class when your application executes a criteria query.
 */
public class CriteriaTest {

	Session session = null;
	InitializeResource initializeResource = null;

	/**
	 * Default Constructor
	 */
	public CriteriaTest() {
		initializeResource = new InitializeResource();
		session = initializeResource.getSession();
	}

	/**
	 * select * from employee.
	 */
	public void criteriaSelect() {
		Criteria ct = session.createCriteria(Employee.class);
		List<Employee> list = ct.list();
		Iterator<Employee> it = list.iterator();
		while (it.hasNext()) {
			Employee emp = it.next();
			System.out.println(emp.getId() + " " + emp.getFirstname() + " "
					+ emp.getLastName() + " " + emp.getGender());
		}
	}

	/**
	 * You can use add() method available for Criteria object to add restriction
	 * for a criteria query.
	 */
	public void criteriaRestrictions() {
		Criteria ct = session.createCriteria(Employee.class);
		// ct.add(Restrictions.eq("id", 12));
		// ct.add(Restrictions.gt("id", 12));
		// ct.add(Restrictions.lt("id", 13));
		ct.add(Restrictions.like("Firstname", "m%"));
		// ct.add(Restrictions.ilike("Firstname", "M%"));
		// ct.add(Restrictions.between("id", 13, 18));
		//ct.add(Restrictions.ne("Firstname", "param"));
		//ct.add(Restrictions.in("Firstname", new String[] { "param", "roja" }));
		// ct.add(Restrictions.isNull("Firstname"));
		// ct.add(Restrictions.isEmpty("Firstname"));
		List<Object> list = ct.list();
		Iterator<Object> it = list.iterator();
		while (it.hasNext()) {
			Employee emp = (Employee) it.next();
			System.out.println(emp.getId() + " " + emp.getFirstname() + " "
					+ emp.getLastName() + " " + emp.getGender());
		}
	}

	/**
	 * You can create AND or OR conditions using LogicalExpression restrictions
	 * as follows....
	 */
	public void criteriaAndOrRestrictions() {
		Criteria ct = session.createCriteria(Employee.class);
		Criterion id = Restrictions.gt("id", 12);
		Criterion name = Restrictions.like("Firstname", "m%");
		// LogicalExpression orExp = Restrictions.or(id, name);
		LogicalExpression andExp = Restrictions.and(id, name);
		ct.add(andExp);

		List<Object> list = ct.list();
		Iterator<Object> it = list.iterator();
		while (it.hasNext()) {
			Employee emp = (Employee) it.next();
			System.out.println(emp.getId() + " " + emp.getFirstname() + " "
					+ emp.getLastName() + " " + emp.getGender());
		}
	}

	/**
	 * Criteria interface for pagination Criteria.setFirstResult(-),
	 * Criteria.setMaxResult(-)
	 */
	public void criteriaPagenation() {
		Criteria ct = session.createCriteria(Employee.class);
		ct.setFirstResult(0);
		ct.setMaxResults(5);
		List<Object> list = ct.list();
		Iterator<Object> it = list.iterator();
		while (it.hasNext()) {
			Employee emp = (Employee) it.next();
			System.out.println(emp.getId() + " " + emp.getFirstname() + " "
					+ emp.getLastName() + " " + emp.getGender());
		}
	}

	/**
	 * The Criteria API provides the org.hibernate.criterion.Order class to sort
	 * your result set in either ascending or descending order, according to one
	 * of your object's properties
	 */
	public void criteriaSortingResult() {
		Criteria ct = session.createCriteria(Employee.class);
		 ct.addOrder(Order.asc("id"));
		//ct.addOrder(Order.desc("Firstname"));
		List<Object> list = ct.list();
		Iterator<Object> it = list.iterator();
		while (it.hasNext()) {
			Employee emp = (Employee) it.next();
			System.out.println(emp.getId() + " " + emp.getFirstname() + " "
					+ emp.getLastName() + " " + emp.getGender());
		}
	}

	/**
	 * The Criteria API provides the org.hibernate.criterion.Projections class,
	 * which can be used to get average, maximum, or minimum of the property
	 * values.
	 */
	public void criteriaProjections() {
		Criteria ct = session.createCriteria(Employee.class);
		System.out.println(ct);
		 ct.setProjection(Projections.rowCount());
		// ct.setProjection(Projections.avg("id"));
		//ct.setProjection(Projections.max("id"));
		// ct.setProjection(Projections.min("id"));
		//ct.setProjection(Projections.sum("id"));

		List<Object> list = ct.list();
		System.out.println(list.get(0));

	}

	/**
	 * The Disjunction and Conjunction classes provide add() methods to apply an
	 * OR or an AND, respectively, between the criteria.
	 */
	public void criteriaDisjunction() {
		Criteria ct = session.createCriteria(Employee.class);
		ct.add(Restrictions.disjunction()
				.add(Restrictions.eq("id", 12))
				.add(Restrictions.eq("id", 13))
				.add(Restrictions.eq("id", 14))
				.add(Restrictions.eq("id", 15)));

		/*ct.add(Restrictions.conjunction()
		 .add(Restrictions.eq("id", 15)));*/

		List<Object> list = ct.list();
		Iterator<Object> it = list.iterator();
		while (it.hasNext()) {
			Employee emp = (Employee) it.next();
			System.out.println(emp.getId() + " " + emp.getFirstname() + " "
					+ emp.getLastName() + " " + emp.getGender());
		}
	}
	
	/**
	 * Condition based on the null or not null on a perticular column.
	 */
	public void restrictionsNullCondition() {
		Criteria ct = session.createCriteria(Employee.class);
		//ct.add(Restrictions.isNotNull("Firstname"));
		ct.add(Restrictions.isNull("Firstname"));
		List<Object> list = ct.list();
		Iterator<Object> it = list.iterator();
		while (it.hasNext()) {
			Employee emp = (Employee) it.next();
			System.out.println(emp.getId() + " " + emp.getFirstname() + " "
					+ emp.getLastName() + " " + emp.getGender());
		}
	}

	public static void main(String[] args) {
		CriteriaTest criteriaTest = new CriteriaTest();
		//criteriaTest.criteriaSelect();
		//criteriaTest.criteriaRestrictions();
		// criteriaTest.criteriaAndOrRestrictions();
		// criteriaTest.criteriaPagenation();
		//criteriaTest.criteriaSortingResult();
		//criteriaTest.criteriaProjections();
		criteriaTest.criteriaDisjunction();
		// criteriaTest.restrictionsNullCondition();
	}
}
