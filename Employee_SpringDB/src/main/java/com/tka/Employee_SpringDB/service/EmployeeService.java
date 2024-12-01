package com.tka.Employee_SpringDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Employee_SpringDB.dao.EmployeeDao;
import com.tka.Employee_SpringDB.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao dao;

	public String InsertData(Employee e) {
		String msg = dao.InsertData(e);
		return msg;
	}

	public String DeleteData(int emp_id) {
		String msg = dao.deleteData(emp_id);
		return msg;
	}

	public String updateData(Employee e, int emp_id) {
		String msg = dao.updateData(e, emp_id);
		return msg;
	}

	public List<Employee> getAllRecords() {
		return dao.getAllRecords();
	}

	public Employee getSingleRecord(int emp_id) {
		return dao.getSingleRecord(emp_id);
	}

}
