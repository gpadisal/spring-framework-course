package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.User;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("formData", new User());
		return "index";
	}
	
	//when form submitted, User object in model
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String processFormData(User user) {
		return "result";
	}
	
	//Redirect the view 	
	@RequestMapping(value="/createAndDisplay", method=RequestMethod.POST)
	public String processFormData(User user, RedirectAttributes attrs) {
		//save the data into Database and redirect to display
		
		attrs.addFlashAttribute("user", user);		
		return "redirect:/display";
	}
	
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public String displayFormD(User user) {
		return "result";
	}	
	

}
