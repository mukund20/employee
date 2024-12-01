package com.tka.Employee_SpringDB.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.Employee_SpringDB.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory factory;

	public String InsertData(Employee e) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(e);
		tr.commit();
		ss.close();
		return "data inserted Successfully..!";
	}

	public String deleteData(int emp_id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Employee e = ss.get(Employee.class, emp_id);
		ss.remove(e);
		tr.commit();
		ss.close();
		return "data deleted Sucessfully";

	}

	public String updateData(Employee e, int emp_id) { // update data
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Employee std = ss.get(Employee.class, emp_id);
		std.setEmp_name(e.getEmp_name());
		std.setSalary(e.getSalary());

		ss.merge(std);
		tr.commit();
		ss.close();
		return "data is updated";
	}

	public List<Employee> getAllRecords() { // get all record
		Session ss = factory.openSession();
		List<Employee> employee = ss.createQuery("from Employee", Employee.class).list();
		ss.close();
		return employee;
	}

	public Employee getSingleRecord(int emp_id) { // get single record
		Session ss = factory.openSession();
		Employee s = ss.get(Employee.class, emp_id);
		ss.close();
		return s;
	}
}
