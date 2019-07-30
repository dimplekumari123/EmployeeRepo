package com.employee.EmployeeDetails.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.employee.EmployeeDetails.entity.Employee;
import com.employee.EmployeeDetails.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
public class EmployeeContollerTest {

	@Mock
	EmployeeService employeeServiceImpl;
	
	@InjectMocks
	EmployeeContoller employeeContoller;
	
	private MockMvc mockmvc;
	Employee emp;
	
	@Before
	public void setup()
	{
		emp= new Employee();
		mockmvc=MockMvcBuilders.standaloneSetup(employeeContoller).build();
	}
	
	public static String asJsonString(final Object obj)
	{
		try {
			return new ObjectMapper().writeValueAsString(obj);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void testCreateEmployee() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.post("/api/createEmp").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL).content(asJsonString(emp))).andExpect(status().isOk());
		
	}

}
