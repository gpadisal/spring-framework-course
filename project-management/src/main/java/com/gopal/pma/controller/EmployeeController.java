package com.gopal.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gopal.pma.dao.EmployeeRepository;
import com.gopal.pma.entity.Employee;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRep;


	@GetMapping("/")
	public String getEmployess(Model model) {
		List<Employee> emps = empRep.findAll();
		model.addAttribute("employees",  emps);
		return "employees/emp-list";
	}
	
	
	@GetMapping("/new")
	public String initEmployee(Model model) {
		model.addAttribute("employee", new Employee() );
		return "employees/new-emp";
	}
	
	@PostMapping("/save")
	public String saveEmployee(Employee emp, Model model) {
		empRep.save(emp);
		return "redirect:/employees/new";
	}
	
}
