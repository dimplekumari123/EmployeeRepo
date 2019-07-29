package com.employee.EmployeeDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.EmployeeDetails.entity.Employee;
import com.employee.EmployeeDetails.exception.RecordNotFoundException;
import com.employee.EmployeeDetails.service.EmployeeServiceImpl;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/api")
public class EmployeeContoller {
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	@PostMapping("/createEmp")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
		Employee emp1 = employeeServiceImpl.createEmployee(emp);
		return new ResponseEntity<Employee>(emp1, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) throws RecordNotFoundException {

		employeeServiceImpl.deleteEmployeeById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee emp)throws RecordNotFoundException {
		Employee emp1 = employeeServiceImpl.updateEmployee(id, emp);
		return new ResponseEntity<Employee>(emp1, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id)throws RecordNotFoundException {
		Employee emp=employeeServiceImpl.getEmployeeById(id);
		return new ResponseEntity<Employee> (emp,HttpStatus.OK);
	}
}
