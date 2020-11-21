package com.gopal.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gopal.pma.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
	@Override
	List<Employee> findAll();

}
