package com.gopal.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gopal.pma.dao.EmployeeRepository;
import com.gopal.pma.dao.ProjectRepository;
import com.gopal.pma.entity.Employee;
import com.gopal.pma.entity.Project;

@Controller
public class HomeController {

	
	@Autowired
	ProjectRepository proRep;
	
	@Autowired
	EmployeeRepository empRep;


	@GetMapping("/")
	public String getAllProjects(Model model) {
		
		List<Project> projects = proRep.findAll();
		model.addAttribute("projects",  projects);
		
		List<Employee> emps = empRep.findAll();
		model.addAttribute("employees",  emps);
		
		return "main/home";
	}
	
	
}
