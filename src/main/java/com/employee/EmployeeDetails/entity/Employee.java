package com.employee.EmployeeDetails.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long empId;
private String name;
private Integer salary;
public Long getEmpId() {
	return empId;
}
public void setEmpId(Long empId) {
	this.empId = empId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getSalary() {
	return salary;
}
public void setSalary(Integer salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
}

}
