package com.gopal.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gopal.pma.dto.EmployeeProject;
import com.gopal.pma.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
	@Override
	List<Employee> findAll();

	@Query(nativeQuery=true, value="SELECT e.first_name as firstName, e.last_name as lastName , count(pe.employee_id) as projectCount " + 
			" FROM EMPLOYEE e left join PROJECT_EMPLOYEE pe on e.employee_id = pe.employee_id " + 
			"group by e.first_name, e.last_name order by 3 desc")
	List<EmployeeProject> employeeProjects();
	
}
