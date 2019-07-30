package com.employee.EmployeeDetails.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.EmployeeDetails.entity.Employee;
import com.employee.EmployeeDetails.exception.RecordNotFoundException;
import com.employee.EmployeeDetails.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public Employee createEmployee(Employee emp) {

		return empRepo.save(emp);
	}

	@Override
	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub

		Optional<Employee> employee = empRepo.findById(id);
		if (employee.isPresent()) {
			empRepo.deleteById(id);
		} else
			throw new RecordNotFoundException("No employee record exist for given id");
	}

	@Override
	public Employee updateEmployee(long id, Employee emp) throws RecordNotFoundException {

		Employee store=null;
		
		Optional<Employee> empRepo1 = empRepo.findById(id);
		if(empRepo1.isPresent())
       {
			store.setName(emp.getName());
			store.setSalary(emp.getSalary());
	    	empRepo.save(store);

		return store;
	}
	else 
		throw new RecordNotFoundException("No employee record exist for given id"); 

}
	@Override
	public Employee getEmployeeById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> employee = empRepo.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
}
