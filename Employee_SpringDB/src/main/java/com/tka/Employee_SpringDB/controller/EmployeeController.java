package com.tka.Employee_SpringDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.Employee_SpringDB.entity.Employee;
import com.tka.Employee_SpringDB.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("/savedata")
	public String insertData(@RequestBody Employee e) {
		String msg = service.InsertData(e);
		return msg;
	}

	@DeleteMapping("/deletedata/{emp_id}")
	public String deleteData(@PathVariable int emp_id) {
		String msg = service.DeleteData(emp_id);
		return msg;
	}

	@PutMapping("/updatedata/{emp_id}")
	public String updateData(@PathVariable int emp_id, @RequestBody Employee e) {
		String msg = service.updateData(e, emp_id);
		return msg;
	}

	@GetMapping("/getallrecords")
	public List<Employee> getAllRecords() {
		return service.getAllRecords();
	}

	@GetMapping("/getrecord/{emp_id}")
	public Employee getSingleRecord(@PathVariable int emp_id) {
		Employee employee = service.getSingleRecord(emp_id);
		return employee;
	}
}
