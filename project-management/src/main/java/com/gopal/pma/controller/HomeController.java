package com.gopal.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gopal.pma.dao.EmployeeRepository;
import com.gopal.pma.dao.ProjectRepository;
import com.gopal.pma.dto.EmployeeProject;
import com.gopal.pma.dto.ProjectStage;
import com.gopal.pma.entity.Employee;
import com.gopal.pma.entity.Project;
import com.gopal.pma.example.Car;

@Controller
public class HomeController {

	
	@Autowired // injected by @Bean definition in Spring Application or Config class
	Car car;
	
	@Autowired
	ProjectRepository proRep; //Automatically created since it extends CrudRepository , so just autowired annotation injects the instance.
	
	@Autowired
	EmployeeRepository empRep;


	@GetMapping("/details")
	public String getAllProjects(Model model) {
		
		List<Project> projects = proRep.findAll();
		model.addAttribute("projects",  projects);
		
		List<Employee> emps = empRep.findAll();
		model.addAttribute("employees",  emps);
		
		return "main/home";
	}
	

	@GetMapping("/")
	public String getProjectsCount(Model model) throws JsonProcessingException {
		
		
		List<Project> projects = proRep.findAll();
		model.addAttribute("projects",  projects);
			
		
		List<ProjectStage> projectStages = proRep.projectStages();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectStages);
		
		model.addAttribute("projectStatusCnt", jsonString);
		
		List<EmployeeProject> emps = empRep.employeeProjects();
		model.addAttribute("employeeProjects",  emps);
		
		return "main/home_count";
	}

	
	
	
}
