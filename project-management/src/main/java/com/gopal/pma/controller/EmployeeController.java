package com.gopal.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gopal.pma.dao.EmployeeRepository;
import com.gopal.pma.dao.ProjectRepository;
import com.gopal.pma.entity.Employee;
import com.gopal.pma.entity.Project;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRep;
	
	@Autowired
	ProjectRepository prjRepo;


	@GetMapping("")
	public String getEmployess(Model model) {
		List<Employee> emps = empRep.findAll();
		model.addAttribute("employees",  emps);
		return "employees/emp-list";
	}
	
	
	@GetMapping("/new")
	public String initEmployee(Model model) {
		model.addAttribute("employee", new Employee() );
		
		//list of projects to show in Create employee page
		List<Project> projects = prjRepo.findAll();
		model.addAttribute("allProjects", projects);
		
		return "employees/new-emp";
	}
	
	//ManyToMany relation
	@PostMapping("/save")
	public String saveEmployee(Employee emp, Model model) {
		empRep.save(emp);
		return "redirect:/employees";
	}
	
}
