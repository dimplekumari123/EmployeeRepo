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

		Employee empRepo1 = empRepo.findById(id).get();
        if(empRepo1.getEmpId() != null && empRepo1.getSalary()<=0) {
		empRepo1.setName(emp.getName());
		empRepo1.setSalary(emp.getSalary());
		empRepo.save(empRepo1);

		return empRepo1;
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
