package com.employee.EmployeeDetails.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.employee.EmployeeDetails.entity.Employee;
import com.employee.EmployeeDetails.repo.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

	@Mock
	EmployeeRepository employeeRepositoryMock;

	@InjectMocks
	EmployeeServiceImpl employeeServiceMock;

	Employee emp;

	@Before
	public void init() {
		emp = new Employee();
		emp.setName("supriya");
		emp.setSalary(30000);
	}

	@Test
	public void testCreateEmployee() {
		when(employeeRepositoryMock.save(Mockito.any())).thenReturn(emp);
		Employee emp1 = new Employee();
		emp1.setName("supriya");
		emp1.setSalary(3000);
		Employee emp2 = employeeServiceMock.createEmployee(emp1);
		assertEquals("supriya", emp.getName());
	}
	
	@Test
	public void updateEmployeeTest()
	{
		when(employeeRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(emp));
		
		Employee emp2=new Employee();
		emp2.setName("supriya");
		emp2.setSalary(3000);
		emp2.setEmpId(1L);
		
		when(employeeRepositoryMock.save(Mockito.any())).thenReturn(emp2);
		
		assertEquals("supriya", emp.getName());
		
	}
	


	
}