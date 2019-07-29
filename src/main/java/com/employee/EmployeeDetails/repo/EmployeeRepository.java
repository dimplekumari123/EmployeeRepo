package com.employee.EmployeeDetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.EmployeeDetails.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
