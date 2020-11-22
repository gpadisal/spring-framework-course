package com.gopal.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gopal.pma.dao.EmployeeRepository;
import com.gopal.pma.dao.ProjectRepository;
import com.gopal.pma.entity.Employee;
import com.gopal.pma.entity.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRep;
	
	
	@Autowired
	EmployeeRepository empRepo;


	@GetMapping("")
	public String getEmployess(Model model) {
		List<Project> projects = proRep.findAll();
		model.addAttribute("projects",  projects);
		return "projects/list-projects";
	}

	
	@GetMapping("/new")
	public String createProject(Model model) {
		model.addAttribute("project", new Project() );
		
		//list of employees to show in Create project page
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
	}
	
	/* ManyToOne uncomment the following block
	 * 
	 * @PostMapping("/save") public String saveProject(Project
	 * project, @RequestParam List<Long> employees, Model model) {
	 * 
	 * //save project proRep.save(project);
	 * 
	 * 
	 * Iterable<Employee> allEmployees = empRepo.findAllById(employees);
	 * 
	 * for(Employee emp: allEmployees) { emp.setProject(project); }
	 * 
	 * //Save each employee to have project Id as foreign key in employee table
	 * empRepo.saveAll(allEmployees);
	 * 
	 * return "redirect:/projects/new"; }
	 */
	
	
	// ManyToMany Relation 
	@PostMapping("/save")
	public String saveProject(Project project, Model model) {
		
		//save project
		proRep.save(project);
				
		return "redirect:/projects";
	}
	
	
	
	
	

}
