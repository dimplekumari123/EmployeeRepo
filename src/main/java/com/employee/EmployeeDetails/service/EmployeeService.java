package com.employee.EmployeeDetails.service;

import com.employee.EmployeeDetails.entity.Employee;
import com.employee.EmployeeDetails.exception.RecordNotFoundException;

public interface EmployeeService {
	public Employee createEmployee(Employee emp);

	public Employee updateEmployee(long id, Employee emp) throws RecordNotFoundException;

	public void deleteEmployeeById(Long id) throws RecordNotFoundException;
     public Employee getEmployeeById(Long id) throws RecordNotFoundException;
}
