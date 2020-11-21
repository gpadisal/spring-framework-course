package com.gopal.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gopal.pma.dao.ProjectRepository;
import com.gopal.pma.entity.Employee;
import com.gopal.pma.entity.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRep;


	@GetMapping("/")
	public String getEmployess(Model model) {
		List<Project> projects = proRep.findAll();
		model.addAttribute("projects",  projects);
		return "projects/prj-list";
	}

	
	@GetMapping("/new")
	public String createProject(Model model) {
		model.addAttribute("project", new Project() );
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String saveProject(Project project, Model model) {
		proRep.save(project);
		return "redirect:/projects/new";
	}

}
