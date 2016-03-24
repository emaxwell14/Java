package com.emaxwell.util;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.emaxwell.domain.User;

public class UserTestUtil {

	private static SessionFactory factory;
/*
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().
					addPackage("com.emaxwell.domain"). //add package if used.
					addAnnotatedClass(User.class).buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		UserTestUtil ME = new UserTestUtil();

		 Add few employee records in database 
		Integer empID1 = ME.addUser("emxawell14", "password1");
	//  Integer empID2 = ME.addUser("testUser1", "password2");
	//	Integer empID3 = ME.addUser("testuser2", "password3");

		 List down all the employees 
		ME.listUsers();

		 Update employee's records 
	//	ME.updateUserPassword(empID1, "passwordUpdated");

		 Delete an employee from the database 
		ME.deleteEmployee(empID1);
		 List down new list of the employees 
		ME.listUsers();
	}
*/
	/* Method to CREATE an employee in the database */
	public Integer addUser(String uName, String pass) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			User employee = new User();
			employee.setUserName(uName);
			employee.setPassword(pass);

			employeeID = (Integer) session.save(employee);
			tx.commit();
			System.out.println("User Created with id " + employeeID);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

	/* Method to READ all the users */
	public void listUsers() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			//TODO check name
			List employees = session.createQuery("FROM User").list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				User employee = (User) iterator.next();
				System.out.println("User Name: " + employee.getUserName());
				System.out.println("Password: " + employee.getPassword());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to UPDATE password for an user */
	public void updateUserPassword(Integer EmployeeID, String password) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User employee = (User) session.get(User.class, EmployeeID);
			employee.setPassword(password);
			session.update(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE an employee from the records */
	public void deleteEmployee(Integer EmployeeID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User employee = (User) session.get(User.class, EmployeeID);
			session.delete(employee);
			System.out.println("User deleted");
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
